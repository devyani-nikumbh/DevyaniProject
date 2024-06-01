package com.example.devyaniproject.myDemo.firestoredatabase

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R
import com.google.firebase.firestore.FirebaseFirestore


class CourseDetails : AppCompatActivity() {
    // creating variables for our recycler view,
    // array list, adapter, firebase firestore
    // and our progress bar.
    private var courseRV: RecyclerView? = null
    private var coursesArrayList: ArrayList<Courses?>? = null
    private var courseRVAdapter: CourseRVAdapter? = null
    private var db: FirebaseFirestore? = null
    var loadingPB: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        // initializing our variables.
        courseRV = findViewById<RecyclerView>(R.id.idRVCourses)
        loadingPB = findViewById<ProgressBar>(R.id.idProgressBar)

        // initializing our variable for firebase
        // firestore and getting its instance.
        db = FirebaseFirestore.getInstance()

        // creating our new array list
        coursesArrayList = ArrayList()
        courseRV?.setHasFixedSize(true)
        courseRV?.setLayoutManager(LinearLayoutManager(this))

        // adding our array list to our recycler view adapter class.
        courseRVAdapter = CourseRVAdapter(coursesArrayList, this)

        // setting adapter to our recycler view.
        courseRV?.setAdapter(courseRVAdapter)

        // below line is use to get the data from Firebase Firestore.
        // previously we were saving data on a reference of Courses
        // now we will be getting the data from the same reference.
        db!!.collection("Courses").get()
            .addOnSuccessListener { queryDocumentSnapshots ->
                // after getting the data we are calling on success method
                // and inside this method we are checking if the received
                // query snapshot is empty or not.
                if (!queryDocumentSnapshots.isEmpty) {
                    // if the snapshot is not empty we are
                    // hiding our progress bar and adding
                    // our data in a list.
                    loadingPB?.setVisibility(View.GONE)
                    val list = queryDocumentSnapshots.getDocuments()
                    for (d in list) {
                        // after getting this list we are passing
                        // that list to our object class.
                        val c = d.toObject(Courses::class.java)
                        c?.id = d.id

                        // and we will pass this object class
                        // inside our arraylist which we have
                        // created for recycler view.
                        coursesArrayList!!.add(c)
                    }
                    // after adding the data to recycler view.
                    // we are calling recycler view notifyDataSetChanged
                    // method to notify that data has been changed in recycler view.
                    courseRVAdapter!!.notifyDataSetChanged()
                } else {
                    // if the snapshot is empty we are displaying a toast message.
                    Toast.makeText(
                        this@CourseDetails,
                        "No data found in Database",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }.addOnFailureListener { // if we do not get any data or any error we are displaying
                // a toast message that we do not get any data
                Toast.makeText(this@CourseDetails, "Fail to get the data.", Toast.LENGTH_SHORT)
                    .show()
            }
    }
}

