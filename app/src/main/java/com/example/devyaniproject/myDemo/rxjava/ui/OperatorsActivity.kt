package com.example.devyaniproject.myDemo.rxjava.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.rxjava.ui.operators.ConcatExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.DelayExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.FilterExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.MapExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.MergeExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.SimpleExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.TimerExampleActivity
import com.example.devyaniproject.myDemo.rxjava.ui.operators.ZipExampleActivity

class OperatorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)
    }

    fun startSimpleActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, SimpleExampleActivity::class.java))
    }

    fun startMapActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, MapExampleActivity::class.java))
    }

    fun startZipActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, ZipExampleActivity::class.java))
    }

    fun startTimerActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, TimerExampleActivity::class.java))
    }

    fun startFilterActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, FilterExampleActivity::class.java))
    }

    fun startConcatActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, ConcatExampleActivity::class.java))
    }

    fun startMergeActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, MergeExampleActivity::class.java))
    }

    fun startDelayActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, DelayExampleActivity::class.java))
    }

}