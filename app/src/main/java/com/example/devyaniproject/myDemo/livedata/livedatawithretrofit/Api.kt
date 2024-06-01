package com.example.devyaniproject.myDemo.livedata.livedatawithretrofit

import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @get:GET("marvel")
    val heroes: Call<List<Hero?>?>?

    companion object {
        const val BASE_URL = "https://simplifiedcoding.net/demos/"
    }
}