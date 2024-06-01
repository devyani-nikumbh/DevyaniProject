package com.example.devyaniproject.myDemo.workmanager

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.devyaniproject.R
import javax.annotation.Nullable


class ActivityWorkManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workmanager)

        // For more information check simplified coding example


        val workRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

        //A click listener for the button
        //inside the onClick method we will perform the work

        //A click listener for the button
        //inside the onClick method we will perform the work
        findViewById<View>(R.id.buttonEnqueue).setOnClickListener { //Enqueuing the work request
            WorkManager.getInstance().enqueue(workRequest)
        }

        val textView = findViewById<TextView>(R.id.textViewStatus)

        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.id)
            .observe(
                this
            ) { workInfo -> textView.append(workInfo?.state?.name + "\n") }
    }

}