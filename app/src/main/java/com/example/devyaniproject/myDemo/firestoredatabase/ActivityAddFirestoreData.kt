package com.example.devyaniproject.myDemo.firestoredatabase

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.firebase.firestore.FirebaseFirestore


class ActivityAddFirestoreData : AppCompatActivity() {
    // creating variables for our edit text
    private var courseNameEdt: EditText? = null
    private var courseDurationEdt: EditText? = null
    private var courseDescriptionEdt: EditText? = null

    // creating variable for button
    private var submitCourseBtn: Button? = null
    private var viewCoursesBtn: Button? = null

    // creating a strings for storing
    // our values from edittext fields.
    private var courseName: String? = null
    private var courseDuration: String? = null
    private var courseDescription: String? = null

    // creating a variable
    // for firebasefirestore.
    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cloud_firestore)

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance()

        // initializing our edittext and buttons
        courseNameEdt = findViewById<EditText>(R.id.idEdtCourseName)
        courseDescriptionEdt = findViewById<EditText>(R.id.idEdtCourseDescription)
        courseDurationEdt = findViewById<EditText>(R.id.idEdtCourseDuration)
        submitCourseBtn = findViewById<Button>(R.id.idBtnSubmitCourse)
        viewCoursesBtn = findViewById<Button>(R.id.idBtnViewCourses)

        // adding onclick listener to view data in new activity
        // adding onclick listener to view data in new activity
        viewCoursesBtn?.setOnClickListener(View.OnClickListener { // opening a new activity on button click
            val i = Intent(this, CourseDetails::class.java)
            startActivity(i)
        })

        // adding on click listener for button
        submitCourseBtn?.setOnClickListener(View.OnClickListener {
            // getting data from edittext fields.
            courseName = courseNameEdt?.getText().toString()
            courseDescription = courseDescriptionEdt?.getText().toString()
            courseDuration = courseDurationEdt?.getText().toString()

            // validating the text fields if empty or not.
            if (TextUtils.isEmpty(courseName)) {
                courseNameEdt?.setError("Please enter Course Name")
            } else if (TextUtils.isEmpty(courseDescription)) {
                courseDescriptionEdt?.setError("Please enter Course Description")
            } else if (TextUtils.isEmpty(courseDuration)) {
                courseDurationEdt?.setError("Please enter Course Duration")
            } else {
                // calling method to add data to Firebase Firestore.
                addDataToFirestore(courseName!!, courseDescription!!, courseDuration!!)
            }
        })
    }

    private fun addDataToFirestore(
        courseName: String,
        courseDescription: String,
        courseDuration: String
    ) {

        // creating a collection reference
        // for our Firebase Firestore database.
        val dbCourses = db!!.collection("Courses")

        // adding our data to our courses object class.
        val courses = Courses(courseName, courseDescription, courseDuration)

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(courses).addOnSuccessListener { // after the data addition is successful
            // we are displaying a success toast message.
            Toast.makeText(
                this,
                "Your Course has been added to Firebase Firestore",
                Toast.LENGTH_SHORT
            ).show()
        }
            .addOnFailureListener { e -> // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(this, "Fail to add course \n$e", Toast.LENGTH_SHORT)
                    .show()
            }
    }
}

