package com.example.devyaniproject.myDemo.livedata.livedatamvvm

import android.view.View

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    private var userMutableLiveData: MutableLiveData<LoginUser>? = null
    val user: MutableLiveData<LoginUser>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData as MutableLiveData<LoginUser>
        }

    fun onClick(view: View?) {
        val loginUser = LoginUser(EmailAddress.getValue()!!, Password.getValue()!!)
        userMutableLiveData!!.value = loginUser
    }
}