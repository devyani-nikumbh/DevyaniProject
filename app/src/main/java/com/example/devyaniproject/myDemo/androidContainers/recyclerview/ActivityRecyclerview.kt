package com.example.devyaniproject.myDemo.androidContainers.recyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devyaniproject.R


class ActivityRecyclerview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val myListData = arrayOf(
            MyListData("Email", android.R.drawable.ic_dialog_email),
            MyListData("Info", android.R.drawable.ic_dialog_info),
            MyListData("Delete", android.R.drawable.ic_delete),
            MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
            MyListData("Alert", android.R.drawable.ic_dialog_alert),
            MyListData("Map", android.R.drawable.ic_dialog_map),
            MyListData("Email", android.R.drawable.ic_dialog_email),
            MyListData("Info", android.R.drawable.ic_dialog_info),
            MyListData("Delete", android.R.drawable.ic_delete),
            MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
            MyListData("Alert", android.R.drawable.ic_dialog_alert),
            MyListData("Map", android.R.drawable.ic_dialog_map)
        )
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val adapter = MyListAdapter(myListData)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(adapter)
    }
}