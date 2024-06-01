package com.example.devyaniproject.myDemo.materialDesignComponents.sliders

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class ActivitySliders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliders)

        // sample text view to show the result
        val tvResult: TextView = findViewById(R.id.tvResult)

        // observe for first type of slider
        val normalContinuousSlider: Slider = findViewById(R.id.normalContinuousSlider)
        normalContinuousSlider.addOnChangeListener { slider, value, fromUser ->
            tvResult.text = value.toString()
        }

        // observe for second type of slider
        val continuousRangeSlider: RangeSlider = findViewById(R.id.continuousRangeSlider)
        continuousRangeSlider.addOnChangeListener { slider, value, fromUser ->
            tvResult.text = "${slider.values[0]} to ${slider.values[1]}"
        }

        // observe for third type of slider
        val discreteSlider: Slider = findViewById(R.id.discreteSlider)
        discreteSlider.addOnChangeListener { slider, value, fromUser ->
            tvResult.text = value.toString()
        }

        // observe for fourth type of slider
        val discreteRangeSlider: RangeSlider = findViewById(R.id.discreteRangeSlider)
        discreteRangeSlider.addOnChangeListener { slider, value, fromUser ->
            tvResult.text = "${slider.values[0]} to ${slider.values[1]}"
        }
    }
}
