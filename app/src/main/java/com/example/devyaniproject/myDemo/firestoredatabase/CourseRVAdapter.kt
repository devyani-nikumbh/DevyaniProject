package com.example.devyaniproject.myDemo.firestoredatabase

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.firestoredatabase.CourseRVAdapter.ViewHolder


class CourseRVAdapter // creating constructor for our adapter class
    (// creating variables for our ArrayList and context
    private val coursesArrayList: ArrayList<Courses?>?, private val context: Context
) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // passing our layout file for displaying our card item
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.course_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // setting data to our text views from our modal class.
        val courses = coursesArrayList?.get(position)
        holder.courseNameTV.text = courses?.courseName
        holder.courseDurationTV.text = courses?.courseDuration
        holder.courseDescTV.text = courses?.courseDescription

        holder.itemView.setOnClickListener {
            val courses = coursesArrayList?.get(position)
            val i = Intent(context, UpdateCourse::class.java)
            i.putExtra("course", courses)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        // returning the size of our array list.
        return coursesArrayList?.size!!
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // creating variables for our text views.
        val courseNameTV: TextView
        val courseDurationTV: TextView
        val courseDescTV: TextView

        init {
            // initializing our text views.
            courseNameTV = itemView.findViewById<TextView>(R.id.idTVCourseName)
            courseDurationTV = itemView.findViewById<TextView>(R.id.idTVCourseDuration)
            courseDescTV = itemView.findViewById<TextView>(R.id.idTVCourseDescription)
        }
    }
}

