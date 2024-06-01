package com.example.devyaniproject.myDemo.androidContainers.listviewWithSearchview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.devyaniproject.R


class ActivityListView : AppCompatActivity() {
    var l: ListView? = null
    var searchView: SearchView? = null

    var tutorials = arrayOf(
        "Algorithms", "Data Structures",
        "Languages", "Interview Corner",
        "GATE", "ISRO CS",
        "UGC NET CS", "CS Subjects",
        "Web Technologies"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        l = findViewById(R.id.list)
        searchView = findViewById(R.id.searchView);

        val arr: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            tutorials
        )
        l?.setAdapter(arr)

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (tutorials.contains(query)) {
                    arr.getFilter().filter(query);
                } else {
                    Toast.makeText(this@ActivityListView, "No Match found", Toast.LENGTH_LONG)
                        .show();
                }
                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                arr.filter.filter(newText)
                return false
            }
        })

    }
}

