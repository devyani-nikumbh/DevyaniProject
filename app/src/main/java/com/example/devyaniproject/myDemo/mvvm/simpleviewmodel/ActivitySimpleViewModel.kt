package com.example.devyaniproject.myDemo.mvvm.simpleviewmodel

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.devyaniproject.R


class ActivitySimpleViewModel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val textView = findViewById<View>(R.id.textView) as TextView
        val button = findViewById<View>(R.id.button) as Button

        // view model instance
        var viewModel: ViewModelSimple = ViewModelProvider(this).get(ViewModelSimple::class.java)

        // setting text view
        textView.text = viewModel.number.toString()

        //handling button click event
        button.setOnClickListener {
            viewModel.addOne()
            textView.text = viewModel.number.toString()
        }
    }
}
