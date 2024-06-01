package com.example.devyaniproject.myDemo.asynchrounsProgramming

import android.app.IntentService
import android.content.Intent
import android.util.Log

class ExampleIntentService// Constructor with a name for the worker thread
// The name is used only for debugging purposes.
    () : IntentService("ExampleIntentService") {

    // This method is called on a worker thread
    // with a request to process.
    override fun onHandleIntent(intent: Intent?) {
        // Perform a task in the background
        Log.d("ExampleIntentService", "Task in progress")
        try {
            // Perform the task for 5 seconds
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            // Print the stack trace
            // if an interruption occurs
            e.printStackTrace()
        }
        Log.d("ExampleIntentService", "Task completed")
    }
}
