package com.example.devyaniproject.myDemo.materialDesignComponents.snackbar


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.devyaniproject.R
import com.google.android.material.snackbar.Snackbar


class ActivitySnackBar : AppCompatActivity() {
    // Button to show the snackbar
    var bShowSnackbar: Button? = null

    // coordinator layout for snackbar
    var mSnackbarLayout: CoordinatorLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        // register the show snackbar button with the appropriate ID
        bShowSnackbar = findViewById<Button>(R.id.show_snackbar_button)

        // register the coordinator layout with the appropriate ID
        mSnackbarLayout = findViewById<CoordinatorLayout>(R.id.snackbar_layout)

        // button click listener to show the snackbar
        bShowSnackbar?.setOnClickListener(View.OnClickListener { // pass the mSnackbarLayout as the view to the "make" function
            val snackbar =
                Snackbar.make(
                    mSnackbarLayout as CoordinatorLayout,
                    "You have deleted an item",
                    Snackbar.LENGTH_LONG
                )
            snackbar.setAction("UNDO") { // perform any action when the button on the snackbar is clicked
                // here in this case it shows a simple toast
                Toast.makeText(this, "The item has been restored", Toast.LENGTH_SHORT)
                    .show()
            }
            // the duration is in terms of milliseconds
            snackbar.setDuration(3000)
            snackbar.show()
        })
    }
}
