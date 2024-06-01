package com.example.devyaniproject.myDemo.dataStorage.internalStorage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.devyaniproject.R
import java.io.IOException
import java.util.Locale


class ActivityInternalStorage : AppCompatActivity(), View.OnClickListener {
    // declare the variables
    var read: AppCompatButton? = null
    var write: AppCompatButton? = null
    var userInput: AppCompatEditText? = null
    var fileContent: AppCompatTextView? = null
    private val filename = "demoFile.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)
        read = findViewById<AppCompatButton>(R.id.read_button)
        write = findViewById<AppCompatButton>(R.id.write_button)
        userInput = findViewById<AppCompatEditText>(R.id.userInput)
        fileContent = findViewById(R.id.content)
        read?.setOnClickListener(this)
        write?.setOnClickListener(this)
    }

    fun printMessage(m: String?) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View) {
        val b = view as Button

        // get the button text : in out case either read or
        // write depending on the button pressed.
        val b_text = b.getText().toString()
        when (b_text.lowercase(Locale.getDefault())) {
            "write" -> {
                writeData()
            }

            "read" -> {
                readData()
            }
        }
    }

    private fun writeData() {
        try {
            val fos = openFileOutput(filename, MODE_PRIVATE)
            val data = userInput!!.getText().toString()
            fos.write(data.toByteArray())
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        userInput!!.setText("")
        printMessage("writing to file " + filename + "completed...")
    }

    private fun readData() {
        try {
            val fin = openFileInput(filename)
            var a: Int
            val temp = StringBuilder()
            while (fin.read().also { a = it } != -1) {
                temp.append(a.toChar())
            }

            // setting text from the file.
            fileContent!!.text = temp.toString()
            fin.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        printMessage("reading to file $filename completed..")
    }
}

