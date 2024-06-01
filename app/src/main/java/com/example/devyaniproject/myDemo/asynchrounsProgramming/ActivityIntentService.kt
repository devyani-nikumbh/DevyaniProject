package com.example.devyaniproject.myDemo.asynchrounsProgramming


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R

class ActivityIntentService : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        // Get a reference to the start service button in the layout
        val startServiceButton = findViewById<Button>(R.id.start_service_button)

        // Set an OnClickListener for the button
        startServiceButton.setOnClickListener {
            // Create an Intent to start
            // the ExampleIntentService
            val intent = Intent(this, ExampleIntentService::class.java)
            // Start the service
            // using the intent
            startService(intent)
        }
    }
}
