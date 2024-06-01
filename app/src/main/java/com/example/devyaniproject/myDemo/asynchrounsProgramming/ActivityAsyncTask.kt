package com.example.devyaniproject.myDemo.asynchrounsProgramming

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class ActivityAsyncTask : AppCompatActivity() {

    var ImageUrl: URL? = null
    var `is`: InputStream? = null
    var bmImg: Bitmap? = null
    var imageView: ImageView? = null
    var p: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        val button = findViewById<Button>(R.id.asyncTask)
        imageView = findViewById<ImageView>(R.id.image)

        button.setOnClickListener {
            val asyncTask: AsyncTaskExample = AsyncTaskExample()
            asyncTask.execute("https://www.tutorialspoint.com/images/tp-logo-diamond.png")
        }
    }

    private inner class AsyncTaskExample : AsyncTask<String?, String?, Bitmap?>() {
        override fun doInBackground(vararg params: String?): Bitmap? {
            try {
                ImageUrl = URL(params[0])
                val conn = ImageUrl!!.openConnection() as HttpURLConnection
                conn.setDoInput(true)
                conn.connect()
                `is` = conn.inputStream
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.RGB_565
                bmImg = BitmapFactory.decodeStream(`is`, null, options)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return bmImg
        }


        override fun onPreExecute() {
            super.onPreExecute()
            p = ProgressDialog(this@ActivityAsyncTask)
            p!!.setMessage("Please wait...It is downloading")
            p!!.isIndeterminate = false
            p!!.setCancelable(false)
            p!!.show()
        }


        override fun onPostExecute(bitmap: Bitmap?) {
            super.onPostExecute(bitmap)
            if (imageView != null) {
                p!!.hide()
                imageView!!.setImageBitmap(bitmap)
            } else {
                p!!.show()
            }
        }
    }
}