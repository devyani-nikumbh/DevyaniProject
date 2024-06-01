package com.example.devyaniproject.mindorkjetpackcompose.materialdesign

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.devyaniproject.mindorkjetpackcompose.button.SimpleTextComponent

class MaterialAppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                SimpleTextComponent(text = "Bottom Appbar")
                BottomAppBarComponent()
                SimpleTextComponent(text = "Top Appbar")
                TopAppBarComponent()
            }
        }
    }
}

@Composable
fun BottomAppBarComponent() {
    // BottomAppBar is a composable that is placed at the bottom of the screen and it contains
    // some actions that are related to the current screen.
    BottomAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Here, this is a RowScope and due this, all the children will be placed
        // horizontally.

        // IconButton consists of an Icon that is behaving like a button. You can think
        // of this as a clickable image.
        IconButton(onClick = {
        }) {
            Icon(Icons.Filled.Menu, "backIcon")
        }
        // Spacer is used to provide some space in between UI elements
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = {
        }) {
            Icon(Icons.Filled.Favorite, "backIcon")
        }
        IconButton(onClick = {

        }) {
            Icon(Icons.Filled.Favorite, "backIcon")
        }
    }
}

@Composable
fun TopAppBarComponent() {
    // TopAppBar is generally used to have the app name or icon for navigation drawer.
    // Basically it is the AppBar that we use in Android.
    TopAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        title = { Text("App Name") },
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(Icons.Filled.Menu, "backIcon")
            }
        },
        actions = {
            // Here, this is a RowScope and due to this, all children will be placed
            // horizontally.
            IconButton(onClick = {

            }) {
                Icon(Icons.Filled.Favorite, "backIcon")
            }
            IconButton(onClick = {

            }) {
                Icon(Icons.Filled.Favorite, "backIcon")
            }
        }
    )
}
