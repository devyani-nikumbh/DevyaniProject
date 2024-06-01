package com.example.devyaniproject.myDemo.layouts.constraintLayoutDemo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R

class ActivityConstraintLayout : AppCompatActivity() {


    // Here I have created constraint layout all demos in xml file
    // you need to change layout to check all demos
    //  1 -- Bias
    // 2 -- chains
    // 3 -- Guidelines
    // 4-- Barriers
    // 5--Groups   *** Practical is pending

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_barriers)
    }
}