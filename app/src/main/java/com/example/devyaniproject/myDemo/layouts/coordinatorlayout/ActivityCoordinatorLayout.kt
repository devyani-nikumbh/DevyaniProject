package com.example.devyaniproject.myDemo.layouts.coordinatorlayout

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import com.example.devyaniproject.R

class ActivityCoordinatorLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        val btnLayoutBased: AppCompatButton = findViewById(R.id.btnLayoutBased)
        val btnScrollBased: AppCompatButton = findViewById(R.id.btnScrollBased)

        btnLayoutBased.setOnClickListener {
            startActivity(Intent(this, LayoutBasedActivity::class.java))
        }

        btnScrollBased.setOnClickListener {
            startActivity(Intent(this, ScrollBasedActivity::class.java))
        }

    }
}