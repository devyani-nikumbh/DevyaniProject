package com.example.devyaniproject.myDemo.layouts.coordinatorlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class LayoutBasedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_based_coordinator)
        setSupportActionBar(findViewById(R.id.toolbar))

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.msg_clicked), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}