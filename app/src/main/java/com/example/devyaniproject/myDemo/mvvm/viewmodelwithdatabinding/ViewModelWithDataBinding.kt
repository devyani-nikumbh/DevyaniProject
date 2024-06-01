package com.example.devyaniproject.myDemo.mvvm.viewmodelwithdatabinding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelWithDataBinding : ViewModel() {
    var text = MutableLiveData(" Welcome to my application ")


    // Here if we click update text text wont be updated for this we need to set text again in activity
    // but we don't want to communicate with activity so that we can use live data to update text we will check this
    // in next live data demo

    fun updateText() {
        text.value = " Text is Updated "
    }
}