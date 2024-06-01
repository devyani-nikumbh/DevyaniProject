package com.example.devyaniproject.myDemo.serviceDemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.devyaniproject.R

class ActivityUnBoundService : AppCompatActivity() , View.OnClickListener {

    // declaring objects of Button class
    private var start: AppCompatButton? = null
    private var stop: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_example)

        // assigning ID of startButton
        // to the object start
        start = findViewById<View>(R.id.startButton) as AppCompatButton

        // assigning ID of stopButton
        // to the object stop
        stop = findViewById<View>(R.id.stopButton) as AppCompatButton

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        start!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        // process to be performed
        // if start button is clicked
        if (view === start) {

            // starting the service
            startService(Intent(this, UnBoundService::class.java))
        }

        // process to be performed
        // if stop button is clicked
        else if (view === stop) {

            // stopping the service
            stopService(Intent(this, UnBoundService::class.java))
        }
    }
}