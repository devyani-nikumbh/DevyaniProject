package com.example.devyaniproject.myDemo.materialDesignComponents.timepicker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class ActivityTimePicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        // create instance of the UI elements
        val pickTimeButton: Button = findViewById(R.id.pick_time_button)
        val previewPickedTimeTextView: TextView = findViewById(R.id.preview_picked_time_textView)

        // handle the pick time button to open
        pickTimeButton.setOnClickListener {

            // instance of MDC time picker
            val materialTimePicker: MaterialTimePicker = MaterialTimePicker.Builder()
                // set the title for the alert dialog
                .setTitleText("SELECT YOUR TIMING")
                // set the default hour for the
                // dialog when the dialog opens
                .setHour(12)
                // set the default minute for the
                // dialog when the dialog opens
                .setMinute(10)
                // set the time format
                // according to the region
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .build()

            materialTimePicker.show(supportFragmentManager, "MainActivity")

            // on clicking the positive button of the time picker
            // dialog update the TextView accordingly
            materialTimePicker.addOnPositiveButtonClickListener {

                val pickedHour: Int = materialTimePicker.hour
                val pickedMinute: Int = materialTimePicker.minute

                // check for single digit hour hour and minute
                // and update TextView accordingly
                val formattedTime: String = when {
                    pickedHour > 12 -> {
                        if (pickedMinute < 10) {
                            "${materialTimePicker.hour - 12}:0${materialTimePicker.minute} pm"
                        } else {
                            "${materialTimePicker.hour - 12}:${materialTimePicker.minute} pm"
                        }
                    }

                    pickedHour == 12 -> {
                        if (pickedMinute < 10) {
                            "${materialTimePicker.hour}:0${materialTimePicker.minute} pm"
                        } else {
                            "${materialTimePicker.hour}:${materialTimePicker.minute} pm"
                        }
                    }

                    pickedHour == 0 -> {
                        if (pickedMinute < 10) {
                            "${materialTimePicker.hour + 12}:0${materialTimePicker.minute} am"
                        } else {
                            "${materialTimePicker.hour + 12}:${materialTimePicker.minute} am"
                        }
                    }

                    else -> {
                        if (pickedMinute < 10) {
                            "${materialTimePicker.hour}:0${materialTimePicker.minute} am"
                        } else {
                            "${materialTimePicker.hour}:${materialTimePicker.minute} am"
                        }
                    }
                }

                // then update the preview TextView
                previewPickedTimeTextView.text = formattedTime
            }
        }
    }
}
