package com.example.devyaniproject.myDemo.materialDesignComponents.navigationrail

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigationrail.NavigationRailView

class ActivityNavigationRailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_rail)

        /*    val navRailFab: FloatingActionButton = findViewById(R.id.nav_rail_fab)
            navRailFab.setOnClickListener {
                Toast.makeText(this, "FAB Clicked!", Toast.LENGTH_SHORT).show()
            }*/

        val navigationRail: NavigationRailView = findViewById(R.id.navigationRail)
        navigationRail.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.files -> {
                    Toast.makeText(this, "Files", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.images -> {
                    Toast.makeText(this, "Images", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.music -> {
                    Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.videos -> {
                    Toast.makeText(this, "Videos", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
}
