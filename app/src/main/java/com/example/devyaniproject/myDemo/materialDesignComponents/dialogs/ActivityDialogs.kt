package com.example.devyaniproject.myDemo.materialDesignComponents.dialogs

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ActivityDialogs : AppCompatActivity() {

    private var tvOpenDialog: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        tvOpenDialog = findViewById(R.id.tvOpenDialog)

        tvOpenDialog?.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.title))
                .setMessage(resources.getString(R.string.supporting_text))
                .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                    // Respond to neutral button press
                }
                .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    // Respond to positive button press
                }
                .show()
        }
    }
}
// we can also create dialog that have cut rounded corner check material design website for this
