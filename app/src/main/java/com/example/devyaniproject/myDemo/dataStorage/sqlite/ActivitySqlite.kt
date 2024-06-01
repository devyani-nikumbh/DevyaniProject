package com.example.devyaniproject.myDemo.dataStorage.sqlite


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R

class ActivitySqlite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        val db = DatabaseHandler(this)

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..")
        db.addContact(Contact("Devyani", "9100000000"))
        db.addContact(Contact("Kiran", "9199999999"))
        db.addContact(Contact("Kayra", "9522222222"))
        db.addContact(Contact("Karthik", "9533333333"))

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..")
        val contacts = db.allContacts
        for (cn in contacts) {
            val log = "Id: " + cn.iD + " ,Name: " + cn.name + " ,Phone: " +
                    cn.phoneNumber
            // Writing Contacts to log
            Log.d("Name: ", log)
        }
    }
}