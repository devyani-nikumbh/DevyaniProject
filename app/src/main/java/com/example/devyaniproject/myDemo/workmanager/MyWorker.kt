package com.example.devyaniproject.myDemo.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.firebase.ActivityNotification


class MyWorker(context: Context?, workerParams: WorkerParameters?) :
    Worker(context!!, workerParams!!) {
    /*
    * This method is responsible for doing the work
    * so whatever work that is needed to be performed
    * we will put it here
    *
    * For example, here I am calling the method displayNotification()
    * It will display a notification
    * So that we will understand the work is executed
    * */

    override fun doWork(): Result {

        Log.d("---->work","HI how are you")

        displayNotification("My Worker", "Hey I finished my work")
        return Result.success()
    }

    /*
        * The method is doing nothing but only generating
    * a simple notification
    * If you are confused about it
    * you should check the Android Notification Tutorial
    * */
    private fun displayNotification(title: String, task: String) {

        val channel_id = "notification_channel"
        var builder: NotificationCompat.Builder = NotificationCompat.Builder(
            ApplicationProvider.getApplicationContext<Context>(),
            channel_id
        )
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setVibrate(
                longArrayOf(
                    1000, 1000, 1000,
                    1000, 1000
                )
            )
            .setContentTitle(title)
            .setContentText(task)
            .setOnlyAlertOnce(true)
        // Create an object of NotificationManager class to
        // notify the
        // user of events that happen in the background.
        val notificationManager =
            ContextCompat.getSystemService(
                applicationContext,
                NotificationManager::class.java
            ) as NotificationManager

        // Check if the Android Version is greater than Oreo
        if (Build.VERSION.SDK_INT
            >= Build.VERSION_CODES.O
        ) {
            val notificationChannel = NotificationChannel(
                channel_id, "web_app",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager!!.createNotificationChannel(
                notificationChannel
            )
        }
        notificationManager!!.notify(0, builder.build())
    }
}

