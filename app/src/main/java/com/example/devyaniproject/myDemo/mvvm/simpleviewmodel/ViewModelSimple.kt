package com.example.devyaniproject.myDemo.mvvm.simpleviewmodel

import androidx.lifecycle.ViewModel

class ViewModelSimple : ViewModel() {

    var number = 0

    fun addOne() {
        number++
    }
}
