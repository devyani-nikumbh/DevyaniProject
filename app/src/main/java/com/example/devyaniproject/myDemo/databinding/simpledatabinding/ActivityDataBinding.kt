package com.example.devyaniproject.myDemo.databinding.simpledatabinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.ActivityDataBindingBinding


class ActivityDataBinding : AppCompatActivity() {
    // Initialize variables
    var binding: ActivityDataBindingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Assign variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding?.btSubmit?.setOnClickListener(View.OnClickListener {
            // Get text from edit text
            val sText: String = binding?.etInput?.getText().toString().trim()

            // Check condition
            if (sText != "") {
                // when text is not empty
                // set text on text view
                binding?.tvOutput?.text = sText
            } else {
                // When text is empty
                // Display Toast
                Toast.makeText(
                    applicationContext, "Please enter text", Toast.LENGTH_SHORT
                ).show()
            }
        })

        // Initialize fragment
        val fragment: Fragment = FragmentDataBinding()

        // Commit fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment).commit()
    }
}

