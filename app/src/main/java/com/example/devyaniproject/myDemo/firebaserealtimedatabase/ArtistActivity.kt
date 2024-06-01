package com.example.devyaniproject.myDemo.firebaserealtimedatabase



import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ArtistActivity : AppCompatActivity() {
    var buttonAddTrack: Button? = null
    var editTextTrackName: EditText? = null
    var seekBarRating: SeekBar? = null
    var textViewRating: TextView? = null
    var textViewArtist: TextView? = null
    var listViewTracks: ListView? = null
    var databaseTracks: DatabaseReference? = null
    var tracks: MutableList<Track?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        val intent = intent

        /*
         * this line is important
         * this time we are not getting the reference of a direct node
         * but inside the node track we are creating a new child with the artist id
         * and inside that node we will store all the tracks with unique ids
         * */databaseTracks = FirebaseDatabase.getInstance().getReference("tracks")
            .child(intent.getStringExtra(ActivityRealtimeDatabase.ARTIST_ID)!!)
        buttonAddTrack = findViewById<View>(R.id.buttonAddTrack) as Button
        editTextTrackName = findViewById<View>(R.id.editTextName) as EditText
        seekBarRating = findViewById<View>(R.id.seekBarRating) as SeekBar
        textViewRating = findViewById<View>(R.id.textViewRating) as TextView
        textViewArtist = findViewById<View>(R.id.textViewArtist) as TextView
        listViewTracks = findViewById<View>(R.id.listViewTracks) as ListView
        tracks = ArrayList()
        textViewArtist!!.text = intent.getStringExtra(ActivityRealtimeDatabase.ARTIST_NAME)
        seekBarRating!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                textViewRating!!.text = i.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        buttonAddTrack!!.setOnClickListener { saveTrack() }
    }

    override fun onStart() {
        super.onStart()
        databaseTracks!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                tracks!!.clear()
                for (postSnapshot in dataSnapshot.getChildren()) {
                    val track = postSnapshot.getValue(
                        Track::class.java
                    )
                    tracks!!.add(track)
                }
                val trackListAdapter = TrackList(this@ArtistActivity, tracks)
                listViewTracks!!.setAdapter(trackListAdapter)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    private fun saveTrack() {
        val trackName = editTextTrackName!!.getText().toString().trim { it <= ' ' }
        val rating = seekBarRating!!.progress
        if (!TextUtils.isEmpty(trackName)) {
            val id = databaseTracks!!.push().getKey()
            val track = Track(id, trackName, rating)
            databaseTracks!!.child(id!!).setValue(track)
            Toast.makeText(this, "Track saved", Toast.LENGTH_LONG).show()
            editTextTrackName!!.setText("")
        } else {
            Toast.makeText(this, "Please enter track name", Toast.LENGTH_LONG).show()
        }
    }
}