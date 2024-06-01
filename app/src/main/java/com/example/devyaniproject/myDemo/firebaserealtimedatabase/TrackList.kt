package com.example.devyaniproject.myDemo.firebaserealtimedatabase

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.devyaniproject.R


/**
 * Created by Belal on 2/26/2017.
 */
class TrackList(private val context: Activity, var tracks: MutableList<Track?>?) :
    ArrayAdapter<Track?>(
        context, R.layout.layout_artist_list,
        tracks!!
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val listViewItem: View = inflater.inflate(R.layout.layout_artist_list, null, true)
        val textViewName = listViewItem.findViewById<View>(R.id.textViewName) as TextView
        val textViewRating = listViewItem.findViewById<View>(R.id.textViewGenre) as TextView
        val track = tracks?.get(position)
        textViewName.text = track?.trackName
        textViewRating.text = track?.rating.toString()
        return listViewItem
    }
}