package com.example.devyaniproject.myDemo.mvvm.viewmodelwithbaseobservable

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.devyaniproject.BR


class AppViewModel : BaseObservable() {
    // creating object of Model class
    private val model: Model

    // string variables for
    // toast messages
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    // getter and setter methods
    // for toast message
    @Bindable // string variable for
    // toast message
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @get:Bindable
    var userEmail: String?
        // getter and setter methods
        get() = model.email
        set(email) {
            model.email = email
            notifyPropertyChanged(BR.userEmail)
        }

    @get:Bindable
    var userPassword: String?
        // getter and setter methods
        get() = model.password
        set(password) {
            model.password = password
            notifyPropertyChanged(BR.userPassword)
        }

    // constructor of ViewModel class
    init {

        // instantiating object of
        // model class
        model = Model("", "")
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
        if (isValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    val isValid: Boolean
        // method to keep a check
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(
            userEmail
        ).matches() && userPassword!!.length > 5
}

