package com.example.devyaniproject.myDemo.rxjava.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.rxjava.ui.search.SearchActivity

class SelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
    }

    fun startOperatorsActivity(view: View) {
        startActivity(Intent(this@SelectionActivity, OperatorsActivity::class.java))
    }

    fun startSearchActivity(view: View) {
        startActivity(Intent(this@SelectionActivity, SearchActivity::class.java))
    }

}