package com.example.devyaniproject.myDemo.materialDesignComponents.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout


class ActivityCustomAlertDialog : AppCompatActivity() {
    private lateinit var tvOpenDialog: TextView
    private lateinit var customAlertDialogView: View
    private lateinit var nameTextField: TextInputLayout
    private lateinit var phoneNumberTextField: TextInputLayout
    private lateinit var addressTextField: TextInputLayout
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
        tvOpenDialog = findViewById(R.id.tvOpenDialog)

        tvOpenDialog.setOnClickListener(View.OnClickListener {
            // Inflate Custom alert dialog view
            customAlertDialogView = LayoutInflater.from(this)
                .inflate(R.layout.activity_custom_alert_dialog, null, false)

            // Launching the custom alert dialog
            launchCustomAlertDialog()
        })
    }

    private fun launchCustomAlertDialog() {
        nameTextField = customAlertDialogView.findViewById(R.id.name_text_field)
        phoneNumberTextField = customAlertDialogView.findViewById(R.id.phone_number_text_field)
        addressTextField = customAlertDialogView.findViewById(R.id.address_text_field)

        // Building the Alert dialog using materialAlertDialogBuilder instance
        materialAlertDialogBuilder.setView(customAlertDialogView)
            .setTitle("Details")
            .setMessage("Enter your basic details")
            .setPositiveButton("Add") { dialog, _ ->
                val name = nameTextField.editText?.text.toString()
                val phoneNumber = phoneNumberTextField.editText?.text.toString()
                val address = addressTextField.editText?.text.toString()

                /**
                 * Do as you wish with the data here --
                 * Download/Clone the repo from my Github to see the entire implementation
                 * using the link provided at the end of the article.
                 */

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                displayMessage("Operation cancelled!")
                dialog.dismiss()
            }
            .show()
    }

    private fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}