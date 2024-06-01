package com.example.devyaniproject.myDemo.hiltDI.data.repository

import com.example.devyaniproject.myDemo.hiltDI.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}