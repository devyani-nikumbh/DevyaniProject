package com.example.devyaniproject.myDemo.menuDemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R

class ActivityOptionMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu_example, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.message -> {
                Toast.makeText(applicationContext, "Shows share icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.picture -> {
                Toast.makeText(applicationContext, "Shows image icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.mode -> {
                Toast.makeText(applicationContext, "Shows call icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.about -> {
                Toast.makeText(applicationContext, "calculator menu", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.exit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
