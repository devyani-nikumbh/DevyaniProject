package com.example.devyaniproject.myDemo.koinDIMVVM.data.api


import com.example.devyaniproject.myDemo.koinDIMVVM.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}