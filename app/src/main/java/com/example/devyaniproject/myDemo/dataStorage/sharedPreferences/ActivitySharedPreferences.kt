package com.example.devyaniproject.myDemo.dataStorage.sharedPreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.devyaniproject.R

class ActivitySharedPreferences : AppCompatActivity() {
    private lateinit var name: AppCompatEditText
    private lateinit var age: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
        name = findViewById(R.id.edit1)
        age = findViewById(R.id.edit2)
    }

    // Fetch the stored data in onResume() Because this is what will be called when the app opens again
    override fun onResume() {
        super.onResume()
        // Fetching the stored data from the SharedPreference
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val s1 = sh.getString("name", "")
        val a = sh.getInt("age", 0)

        // Setting the fetched data in the EditTexts
        name.setText(s1)
        age.setText(a.toString())
    }

    // Store the data in the SharedPreference in the onPause() method
    // When the user closes the application onPause() will be called and data will be stored
    override fun onPause() {
        super.onPause()
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.text.toString())
        myEdit.putInt("age", age.text.toString().toInt())
        myEdit.apply()
    }
}
