package com.example.devyaniproject.myDemo.menuDemo

import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.devyaniproject.R

class ActivityPopUpMenu : AppCompatActivity() {
    lateinit var button: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_menu)

        // Referencing and Initializing the button
        button = findViewById(R.id.clickBtn)

        // Setting onClick behavior to the button
        button.setOnClickListener {
            // Initializing the popup menu and giving the reference as current context
            val popupMenu = PopupMenu(this, button)

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Toast message on menu item clicked
                Toast.makeText(
                    this,
                    "You Clicked " + menuItem.title,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            // Showing the popup menu
            popupMenu.show()
        }
    }
}
