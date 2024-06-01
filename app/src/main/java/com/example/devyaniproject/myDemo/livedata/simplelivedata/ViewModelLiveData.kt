package com.example.devyaniproject.myDemo.livedata.simplelivedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelLiveData : ViewModel() {

    // Initialize variable
    var mutableLiveData = MutableLiveData<String>()

    // Create set text method
    fun setText(s: String) {
        // Set value
        mutableLiveData.value = s
    }

    // Create get text method
    fun getText(): MutableLiveData<String> {
        // return value
        return mutableLiveData
    }

}