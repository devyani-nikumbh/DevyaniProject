package com.example.devyaniproject.myDemo.downloadmanager

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R


class ActivityDownloadManager : AppCompatActivity() {

    var download: Button? = null
    var viewdownload: Button? = null
    var manager: DownloadManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)

        download = findViewById<Button>(R.id.download)
        viewdownload = findViewById<Button>(R.id.view_download)

        download?.setOnClickListener(View.OnClickListener {
            manager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            val uri =
                Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
            val request = DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            val reference = manager!!.enqueue(request)
        })

        viewdownload?.setOnClickListener {
            val i = Intent()
            i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS)
            startActivity(i)
        }
    }
}