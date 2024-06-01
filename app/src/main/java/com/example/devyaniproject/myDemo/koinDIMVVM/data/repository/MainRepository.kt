package com.example.devyaniproject.myDemo.koinDIMVVM.data.repository

import com.example.devyaniproject.myDemo.koinDIMVVM.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}