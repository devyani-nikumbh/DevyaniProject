package com.example.devyaniproject.myDemo.koinDIMVVM.data.api

import com.example.devyaniproject.myDemo.koinDIMVVM.data.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}