package com.example.devyaniproject.mindorkjetpackcompose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devyaniproject.mindorkjetpackcompose.data.Blog
import com.example.devyaniproject.mindorkjetpackcompose.data.getBlogList

class ScrollableRowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(
                    "Scroll Horizontally --->",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Red
                    ),
                    modifier = Modifier.padding(16.dp)
                )
                ScrollableRowComponent(blogList = getBlogList())
            }
        }
    }
}

@Composable
fun ScrollableRowComponent(blogList: List<Blog>) {
    // ScrollableRow is a composable that is used to keep all its children in horizontal orientation
    // and at the same time it is scrollable also i.e. when the content will cover the whole width of
    // the screen, then you can scroll right and see other contents. It behaves similar to horizontal
    // ScrollView.

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        for (blog in blogList) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(16.dp),
                backgroundColor = Color(0xFFFFA867.toInt())
            ) {
                Text(
                    blog.name,
                    style = TextStyle(
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}