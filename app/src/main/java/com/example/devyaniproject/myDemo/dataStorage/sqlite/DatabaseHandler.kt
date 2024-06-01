package com.example.devyaniproject.myDemo.dataStorage.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHandler(context: Context?) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            ("CREATE TABLE " + TABLE_CONTACTS + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                    + KEY_PH_NO + " TEXT" + ")")
        db.execSQL(CREATE_CONTACTS_TABLE)
    }

    // Upgrading database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)

        // Create tables again
        onCreate(db)
    }

    // code to add the new contact
    fun addContact(contact: Contact) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.name) // Contact Name
        values.put(KEY_PH_NO, contact.phoneNumber) // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    // code to get the single contact
    fun getContact(id: Int): Contact {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf<String>(
                KEY_ID,
                KEY_NAME, KEY_PH_NO
            ),
            KEY_ID + "=?",
            arrayOf<String>(id.toString()),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact
        return Contact(
            cursor!!.getString(0).toInt(),
            cursor.getString(1), cursor.getString(2)
        )
    }

    val allContacts: List<Contact>
        // code to get all contacts in a list view
        get() {
            val contactList: MutableList<Contact> = ArrayList()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    val contact = Contact()
                    contact.iD = cursor.getString(0).toInt()
                    contact.name = cursor.getString(1)
                    contact.phoneNumber = cursor.getString(2)
                    // Adding contact to list
                    contactList.add(contact)
                } while (cursor.moveToNext())
            }

            // return contact list
            return contactList
        }

    // code to update the single contact
    fun updateContact(contact: Contact): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.name)
        values.put(KEY_PH_NO, contact.phoneNumber)

        // updating row
        return db.update(
            TABLE_CONTACTS,
            values,
            KEY_ID + " = ?",
            arrayOf<String>(java.lang.String.valueOf(contact.iD))
        )
    }

    // Deleting single contact
    fun deleteContact(contact: Contact) {
        val db = this.writableDatabase
        db.delete(
            TABLE_CONTACTS,
            KEY_ID + " = ?",
            arrayOf<String>(java.lang.String.valueOf(contact.iD))
        )
        db.close()
    }

    val contactsCount: Int
        // Getting contacts Count
        get() {
            val countQuery = "SELECT  * FROM " + TABLE_CONTACTS
            val db = this.readableDatabase
            val cursor = db.rawQuery(countQuery, null)
            cursor.close()

            // return count
            return cursor.count
        }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contactsManager"
        private const val TABLE_CONTACTS = "contacts"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PH_NO = "phone_number"
    }
}