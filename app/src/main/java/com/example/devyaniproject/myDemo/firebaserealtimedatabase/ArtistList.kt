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
class ArtistList(private val context: Activity, var artists: MutableList<Artist?>?) :
    ArrayAdapter<Artist?>(
        context, R.layout.layout_artist_list,
        artists!!
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val listViewItem: View = inflater.inflate(R.layout.layout_artist_list, null, true)
        val textViewName = listViewItem.findViewById<View>(R.id.textViewName) as TextView
        val textViewGenre = listViewItem.findViewById<View>(R.id.textViewGenre) as TextView
        val artist = artists?.get(position)
        textViewName.text = artist?.artistName
        textViewGenre.text = artist?.artistGenre
        return listViewItem
    }
}