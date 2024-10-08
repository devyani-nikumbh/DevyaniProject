package com.example.devyaniproject.myDemo.livedata.livedatawithretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HeroesViewModel : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var heroList: MutableLiveData<List<Hero>>? = null
    val heroes: LiveData<List<Hero>>
        //we will call this method to get the data
        get() {
            //if the list is null
            if (heroList == null) {
                heroList = MutableLiveData()
                //we will load it asynchronously from server in this method
                loadHeroes()
            }

            //finally we will return the list
            return heroList as MutableLiveData<List<Hero>>
        }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadHeroes() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(
            Api::class.java
        )
        val call: Call<List<Hero?>?>? = api.heroes
        call?.enqueue(object : Callback<List<Hero?>?> {
            override fun onResponse(call: Call<List<Hero?>?>?, response: Response<List<Hero?>?>) {

                //finally we are setting the list to our MutableLiveData
                heroList!!.setValue(response.body() as List<Hero>?)
            }

            override fun onFailure(call: Call<List<Hero?>?>?, t: Throwable?) {}
        })
    }
}