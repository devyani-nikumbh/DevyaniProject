package com.example.devyaniproject.myDemo.hiltDI.data.api

import com.example.devyaniproject.myDemo.hiltDI.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}