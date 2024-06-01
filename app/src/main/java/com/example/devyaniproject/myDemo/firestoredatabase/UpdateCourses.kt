package com.example.devyaniproject.myDemo.firestoredatabase


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.MainActivity
import com.example.devyaniproject.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore


class UpdateCourse : AppCompatActivity() {
    // creating variables for our edit text
    private var courseNameEdt: EditText? = null
    private var courseDurationEdt: EditText? = null
    private var courseDescriptionEdt: EditText? = null

    // creating a strings for storing our values from Edittext fields.
    private var courseName: String? = null
    private var courseDuration: String? = null
    private var courseDescription: String? = null

    // creating a variable for firebasefirestore.
    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_course)
        val courses = intent.getSerializableExtra("course") as Courses?

        // getting our instance from Firebase Firestore.
        db = FirebaseFirestore.getInstance()

        // initializing our edittext and buttons
        courseNameEdt = findViewById<EditText>(R.id.idEdtCourseName)
        courseDescriptionEdt = findViewById<EditText>(R.id.idEdtCourseDescription)
        courseDurationEdt = findViewById<EditText>(R.id.idEdtCourseDuration)

        // creating variable for button
        val updateCOurseBtn = findViewById<Button>(R.id.idBtnUpdateCourse)
        val deleteBtn = findViewById<Button>(R.id.idBtnUpdateCourse)

        courseNameEdt?.setText(courses!!.courseName)
        courseDescriptionEdt?.setText(courses?.courseDescription)
        courseDurationEdt?.setText(courses?.courseDuration)

        // adding on click listener for delete button
        // adding on click listener for delete button
        deleteBtn.setOnClickListener { // calling method to delete the course.
            if (courses != null) {
                deleteCourse(courses)
            }
        }


        updateCOurseBtn.setOnClickListener {
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
                // calling a method to update our course.
                // we are passing our object class, course name,
                // course description and course duration from our edittext field.
                updateCourses(courses, courseName!!, courseDescription!!, courseDuration!!)
            }
        }
    }

    private fun updateCourses(
        courses: Courses?,
        courseName: String,
        courseDescription: String,
        courseDuration: String
    ) {
        val updatedCourse = Courses(courseName, courseDescription, courseDuration)

        db?.collection("Courses")?.document(courses?.id!!)?.set(updatedCourse)
            ?.addOnSuccessListener {
                Toast.makeText(this, "Course has been updated..", Toast.LENGTH_SHORT).show();
            }
    }

    private fun deleteCourse(courses: Courses) {
        db!!.collection("Courses").document(courses.id!!)
            .delete().addOnSuccessListener {
                Toast.makeText(
                    this@UpdateCourse,
                    "Course has been deleted from Database.",
                    Toast.LENGTH_SHORT
                ).show()
                val i = Intent(
                    this@UpdateCourse,
                    ActivityAddFirestoreData::class.java
                )
                startActivity(i)
            }

    }
}

