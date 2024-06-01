package com.example.devyaniproject.myDemo.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.example.devyaniproject.myDemo.retrofit.APIClient.client
import com.example.devyaniproject.myDemo.retrofit.pojo.MultipleResource
import com.example.devyaniproject.myDemo.retrofit.pojo.User
import com.example.devyaniproject.myDemo.retrofit.pojo.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActivityRetrofit : AppCompatActivity() {
    var responseText: TextView? = null
    var apiInterface: APIInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_demo)

        responseText = findViewById<View>(R.id.responseText) as TextView
        apiInterface = client!!.create(APIInterface::class.java)
        /**
         * GET List Resources
         */
        val call: Call<MultipleResource?>? = apiInterface?.doGetListResources()
        call?.enqueue(object : Callback<MultipleResource?> {
            override fun onResponse(
                call: Call<MultipleResource?>?,
                response: Response<MultipleResource?>
            ) {
                Log.d("TAG", response.code().toString())
                var displayResponse = ""
                val resource: MultipleResource? = response.body()
                val text = resource?.page
                val total = resource?.total
                val totalPages = resource?.totalPages
                val datumList = resource?.data
                displayResponse += """${text.toString()} Page
$total Total
$totalPages Total Pages
"""
                if (datumList != null) {
                    for (datum in datumList) {
                        displayResponse += datum.id.toString() + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n"
                    }
                }
                responseText!!.text = displayResponse
            }

            override fun onFailure(call: Call<MultipleResource?>, t: Throwable?) {
                call.cancel()
            }
        })
        /**
         * Create new user
         */
        val user = User("morpheus", "leader")
        val call1: Call<User?>? = apiInterface?.createUser(user)
        call1?.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>) {
                val user1: User? = response.body()
                Toast.makeText(
                    applicationContext,
                    user1?.name + " " + user1?.job + " " + user1?.id + " " + user1?.createdAt,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<User?>, t: Throwable?) {
                call.cancel()
            }
        })
        /**
         * GET List Users
         */
        val call2: Call<UserList?>? = apiInterface?.doGetUserList("2")
        call2?.enqueue(object : Callback<UserList?> {
            override fun onResponse(call: Call<UserList?>?, response: Response<UserList?>) {
                val userList: UserList? = response.body()
                val text = userList?.page
                val total = userList?.total
                val totalPages = userList?.totalPages
                val datumList = userList?.data
                Toast.makeText(
                    applicationContext, """${text.toString()} page
$total total
$totalPages totalPages
""", Toast.LENGTH_SHORT
                ).show()
                if (datumList != null) {
                    for (datum in datumList) {
                        Toast.makeText(
                            applicationContext,
                            "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call<UserList?>, t: Throwable?) {
                call.cancel()
            }
        })
        /**
         * POST name and job Url encoded.
         */
        val call3: Call<UserList?>? = apiInterface?.doCreateUserWithField("morpheus", "leader")
        call3?.enqueue(object : Callback<UserList?> {
            override fun onResponse(call: Call<UserList?>?, response: Response<UserList?>) {
                val userList: UserList? = response.body()
                val text = userList?.page
                val total = userList?.total
                val totalPages = userList?.totalPages
                val datumList = userList?.data
                Toast.makeText(
                    applicationContext, """${text.toString()} page
$total total
$totalPages totalPages
""", Toast.LENGTH_SHORT
                ).show()
                if (datumList != null) {
                    for (datum in datumList) {
                        Toast.makeText(
                            applicationContext,
                            "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call<UserList?>, t: Throwable?) {
                call.cancel()
            }
        })
    }
}

