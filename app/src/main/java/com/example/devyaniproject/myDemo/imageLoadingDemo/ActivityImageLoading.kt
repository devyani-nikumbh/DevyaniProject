package com.example.devyaniproject.myDemo.imageLoadingDemo


import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.devyaniproject.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.squareup.picasso.Picasso


class ActivityImageLoading : AppCompatActivity() {

    lateinit var image: AppCompatImageView
    lateinit var image1: AppCompatImageView
    lateinit var image3: AppCompatImageView
    lateinit var image2: SimpleDraweeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_image_loading)

        image = findViewById(R.id.image)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)

        // we use listners in glide to show progress bar and other things as per requirement
        /*
        *   advance usage glide
        *     1- Resize
        *     2- place holder
        *     3- Handling errors
        *     4- GIFs support
        *     5-  Blur effect
        *     6- circle crop
        *     7- rounded corners
        *
        *     Check geeks for geeks example for proper understanding
        * */

        Glide.with(this)
            .load("https://i.imgur.com/DvpvklR.png")
            .centerCrop()
            .placeholder(android.R.drawable.btn_star)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
            .into(image);


        /*
         *    Features of picasso
         *    1- Resize
         *    2- Placeholder
         *    3- Error Fallback
         *    4- Cropping
        * */

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(image1)


        val imageUri =
            Uri.parse("https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png")
        image2.setImageURI(imageUri)


        // features blur , circle crop , gray scale , rounded corner

        image3.load("https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png")
    }
}