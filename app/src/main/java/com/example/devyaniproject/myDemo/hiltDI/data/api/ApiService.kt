package com.example.devyaniproject.myDemo.hiltDI.data.api

import com.example.devyaniproject.myDemo.hiltDI.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}