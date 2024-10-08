package com.example.devyaniproject.myDemo.googlemap

import com.example.devyaniproject.R
import android.app.Activity
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker


class CustomInfoWindowAdapter(private val context: Activity) : InfoWindowAdapter {
    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun getInfoContents(marker: Marker): View? {
        val view: View = context.layoutInflater.inflate(R.layout.customwindow, null)
        val tvTitle = view.findViewById<View>(R.id.tv_title) as TextView
        val tvSubTitle = view.findViewById<View>(R.id.tv_subtitle) as TextView
        tvTitle.text = marker.title
        tvSubTitle.text = marker.snippet
        return view
    }
}