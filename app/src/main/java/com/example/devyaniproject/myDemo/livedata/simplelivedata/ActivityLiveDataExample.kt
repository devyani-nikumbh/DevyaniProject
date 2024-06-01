package com.example.devyaniproject.myDemo.livedata.simplelivedata

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.devyaniproject.R


class ActivityLiveDataExample : AppCompatActivity() {

    // Initialize variables
    var editText: EditText? = null
    var mainViewModel: ViewModelLiveData? = null

    // Initialize variable
    var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_livedata)

        // Assign variables
        editText = findViewById<EditText>(R.id.et_text)
        // Assign variable
        tvResult = findViewById<TextView>(R.id.tv_result)

        // Initialize view model
        mainViewModel = ViewModelProvider(this).get(ViewModelLiveData::class.java)

        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // When text change
                // Update view model text
                mainViewModel?.setText(charSequence.toString())
            }

            override fun afterTextChanged(editable: Editable) {}
        })

        // Set observer on get text method
        mainViewModel?.getText()?.observe(
            this@ActivityLiveDataExample
        ) { s -> // When text change
            // set result text on text view
            tvResult?.text = s
        }
    }

}