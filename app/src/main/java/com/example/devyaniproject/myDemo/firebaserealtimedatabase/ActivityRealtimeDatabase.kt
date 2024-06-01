package com.example.devyaniproject.myDemo.firebaserealtimedatabase

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class ActivityRealtimeDatabase : AppCompatActivity() {
    //view objects
    var editTextName: EditText? = null
    var spinnerGenre: Spinner? = null
    var buttonAddArtist: Button? = null
    var listViewArtists: ListView? = null

    //a list to store all the artist from firebase database
    var artists: MutableList<Artist?>? = null

    //our database reference object
    var databaseArtists: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realtime_database)

        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists")

        //getting views
        editTextName = findViewById<View>(R.id.editTextName) as EditText
        spinnerGenre = findViewById<View>(R.id.spinnerGenres) as Spinner
        listViewArtists = findViewById<View>(R.id.listViewArtists) as ListView
        buttonAddArtist = findViewById<View>(R.id.buttonAddArtist) as Button

        //list to store artists
        artists = ArrayList()


        //adding an onclicklistener to button
        buttonAddArtist!!.setOnClickListener { //calling the method addArtist()
            //the method is defined below
            //this method is actually performing the write operation
            addArtist()
        }
        listViewArtists!!.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l -> //getting the selected artist
                val artist = artists?.get(i)

                //creating an intent
                val intent = Intent(
                    applicationContext,
                    ArtistActivity::class.java
                )

                //putting artist name and id to intent
                intent.putExtra(ARTIST_ID, artist!!.artistId)
                intent.putExtra(ARTIST_NAME, artist.artistName)

                //starting the activity with intent
                startActivity(intent)
            }
        listViewArtists!!.setOnItemLongClickListener { adapterView, view, i, l ->
            val artist = artists?.get(i)
            showUpdateDeleteDialog(artist!!.artistId, artist.artistName)
            true
        }
    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private fun addArtist() {
        //getting the values to save
        val name = editTextName!!.getText().toString().trim { it <= ' ' }
        val genre = spinnerGenre!!.getSelectedItem().toString()

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            val id = databaseArtists!!.push().getKey()

            //creating an Artist Object
            val artist = Artist(id, name, genre)

            //Saving the Artist
            databaseArtists!!.child(id!!).setValue(artist)

            //setting edittext to blank again
            editTextName!!.setText("")

            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show()
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        //attaching value event listener
        databaseArtists!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //clearing the previous artist list
                artists!!.clear()

                //iterating through all the nodes
                for (postSnapshot in dataSnapshot.getChildren()) {
                    //getting artist
                    val artist = postSnapshot.getValue(
                        Artist::class.java
                    )
                    //adding artist to the list
                    artists!!.add(artist)
                }

                //creating adapter
                val artistAdapter = ArtistList(this@ActivityRealtimeDatabase, artists)
                //attaching adapter to the listview
                listViewArtists!!.setAdapter(artistAdapter)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    private fun showUpdateDeleteDialog(artistId: String?, artistName: String?) {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView: View = inflater.inflate(R.layout.update_dialog, null)
        dialogBuilder.setView(dialogView)
        val editTextName = dialogView.findViewById<View>(R.id.editTextName) as EditText
        val spinnerGenre = dialogView.findViewById<View>(R.id.spinnerGenres) as Spinner
        val buttonUpdate = dialogView.findViewById<View>(R.id.buttonUpdateArtist) as Button
        val buttonDelete = dialogView.findViewById<View>(R.id.buttonDeleteArtist) as Button
        dialogBuilder.setTitle(artistName)
        val b: AlertDialog = dialogBuilder.create()
        b.show()
        buttonUpdate.setOnClickListener {
            val name = editTextName.getText().toString().trim { it <= ' ' }
            val genre = spinnerGenre.getSelectedItem().toString()
            if (!TextUtils.isEmpty(name)) {
                updateArtist(artistId, name, genre)
                b.dismiss()
            }
        }
        buttonDelete.setOnClickListener {
            deleteArtist(artistId)
            b.dismiss()
        }
    }

    private fun updateArtist(id: String?, name: String, genre: String): Boolean {
        //getting the specified artist reference
        val dR = FirebaseDatabase.getInstance().getReference("artists").child(id!!)

        //updating artist
        val artist = Artist(id, name, genre)
        dR.setValue(artist)
        Toast.makeText(applicationContext, "Artist Updated", Toast.LENGTH_LONG).show()
        return true
    }

    private fun deleteArtist(id: String?): Boolean {
        //getting the specified artist reference
        val dR = FirebaseDatabase.getInstance().getReference("artists").child(id!!)

        //removing artist
        dR.removeValue()

        //getting the tracks reference for the specified artist
        val drTracks = FirebaseDatabase.getInstance().getReference("tracks").child(
            id
        )

        //removing all tracks
        drTracks.removeValue()
        Toast.makeText(applicationContext, "Artist Deleted", Toast.LENGTH_LONG).show()
        return true
    }

    companion object {
        //we will use these constants later to pass the artist name and id to another activity
        const val ARTIST_NAME = "artistname"
        const val ARTIST_ID = "artistid"
    }
}