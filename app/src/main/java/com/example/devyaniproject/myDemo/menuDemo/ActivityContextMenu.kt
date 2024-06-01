package com.example.devyaniproject.myDemo.menuDemo

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.devyaniproject.R

class ActivityContextMenu : AppCompatActivity() {
    lateinit var textView: AppCompatTextView
    lateinit var relativeLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        // Link those objects with their respective id's that we have given in .XML file
        textView = findViewById(R.id.textView)
        relativeLayout = findViewById(R.id.relLayout)

        // here you have to register a view for context menu you can register any view
        // like listview, image view, textview, button etc
        registerForContextMenu(textView)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color")
        // add menu items
        menu.add(0, v.id, 0, "Yellow")
        menu.add(0, v.id, 0, "Gray")
        menu.add(0, v.id, 0, "Cyan")
    }

    // menu item select listener
    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.title === "Yellow") {
            relativeLayout.setBackgroundColor(Color.YELLOW)
        } else if (item.title === "Gray") {
            relativeLayout.setBackgroundColor(Color.GRAY)
        } else if (item.title === "Cyan") {
            relativeLayout.setBackgroundColor(Color.CYAN)
        }
        return true
    }
}
