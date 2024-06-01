package com.example.devyaniproject.myDemo.androidContainers

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R

class ActivityWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val mywebview = findViewById<View>(R.id.webView) as WebView
        mywebview.loadUrl("https://www.javatpoint.com/");

/*
        var data = "<html><body><h1>Hello, Javatpoint!</h1></body></html>";
        mywebview.loadData(data, "text/html", "UTF-8");
*/

        // we can also load from asset resources from android
        // mywebview.loadUrl("file:///android_asset/myresource.html")
    }
}