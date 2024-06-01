package com.example.devyaniproject.myDemo.materialDesignComponents.seekbar


import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R


class ActivitySeekbar : AppCompatActivity() {

    // Define the global variable
    var seekbar: SeekBar? = null
    var Text_message: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)


        // use findViewById() to get the Button
        // use findViewById() to get the Button
        Text_message = findViewById<View>(R.id.message_id) as TextView
        seekbar = findViewById<View>(R.id.seekbar) as SeekBar

        seekbar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Text_message!!.setTextSize((progress + 1).toFloat());
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // This method will automatically
                // called when the user touches the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // This method will automatically
                // called when the user
                // stops touching the SeekBar
            }

        })

    }

}

