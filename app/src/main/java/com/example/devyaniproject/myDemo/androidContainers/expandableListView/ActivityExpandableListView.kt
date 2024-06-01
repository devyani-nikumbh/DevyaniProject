package com.example.devyaniproject.myDemo.androidContainers.expandableListView

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.androidContainers.expandableListView.ExpandableListDataItems.data

class ActivityExpandableListView : AppCompatActivity() {

    var expandableListViewExample: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableTitleList: List<String>? = null
    var expandableDetailList: HashMap<String, List<String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_listview)

        expandableListViewExample =
            findViewById<View>(R.id.expandableListViewSample) as ExpandableListView

        expandableDetailList = data
        expandableTitleList = ArrayList(expandableDetailList!!.keys)

        expandableListAdapter = CustomizedExpandableListAdapter(
            this, expandableTitleList as ArrayList<String>,
            expandableDetailList!!
        )
        expandableListViewExample!!.setAdapter(expandableListAdapter)

        // This method is called when the group is expanded
        expandableListViewExample!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(
                applicationContext,
                (expandableTitleList as ArrayList<String>).get(groupPosition) + " List Expanded.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // This method is called when the group is collapsed
        expandableListViewExample!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(
                applicationContext,
                (expandableTitleList as ArrayList<String>).get(groupPosition) + " List Collapsed.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        expandableListViewExample!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                applicationContext,
                (expandableTitleList as ArrayList<String>).get(groupPosition)
                        + " -> "
                        + expandableDetailList!![(expandableTitleList as ArrayList<String>).get(
                    groupPosition
                )]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    }
}

