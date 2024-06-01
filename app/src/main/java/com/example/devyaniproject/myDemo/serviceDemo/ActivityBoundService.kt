package com.example.devyaniproject.myDemo.serviceDemo


import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.serviceDemo.BoundService.MyBinder

class ActivityBoundService : AppCompatActivity() {
    var mBoundService: BoundService? = null
    var mServiceBound = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_service)
        val timestampText = findViewById<View>(R.id.timestamp_text) as AppCompatTextView
        val printTimestampButton = findViewById<View>(R.id.print_timestamp) as AppCompatButton
        val stopServiceButon = findViewById<View>(R.id.stop_service) as AppCompatButton
        printTimestampButton.setOnClickListener {
            if (mServiceBound) {
                timestampText.text = mBoundService!!.timestamp
            }
        }
        stopServiceButon.setOnClickListener {
            if (mServiceBound) {
                unbindService(mServiceConnection)
                mServiceBound = false
            }
            val intent = Intent(
                this,
                BoundService::class.java
            )
            stopService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, BoundService::class.java)
        startService(intent)
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if (mServiceBound) {
            unbindService(mServiceConnection)
            mServiceBound = false
        }
    }

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val myBinder = service as MyBinder
            mBoundService = myBinder.service
            mServiceBound = true
        }
    }
}