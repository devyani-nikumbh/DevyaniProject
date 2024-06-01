package com.example.devyaniproject.mindorkjetpackcompose.image

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.devyaniproject.R

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "This is a Simple Image"
                )
                SimpleImageComponent()
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "This is an image with rounded corners"
                )
                RoundedImageComponent()
            }
        }
    }
}

@Composable
fun SimpleImageComponent() {
    // Image is a composable that is used to display some image.
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painterResource(R.drawable.strawberry),"")
    }
}

@Composable
fun RoundedImageComponent() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // contentScale is used to find the scaling aspect ratio
        Image(
            painterResource(R.drawable.strawberry),"",
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
    }
}