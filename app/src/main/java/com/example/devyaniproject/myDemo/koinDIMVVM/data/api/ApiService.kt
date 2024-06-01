package com.example.devyaniproject.myDemo.koinDIMVVM.data.api

import com.example.devyaniproject.myDemo.koinDIMVVM.data.model.User
import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    /*    @FormUrlEncoded
        @POST("login")
        suspend fun doLogin(
            @Field("firebaseToken") firebaseToken: String,
            @Field("phone") name: String,
            @Field("device_type") device_type: String,
        ): Response<LoginModel>

        @Multipart
        @POST("profile/update")
        suspend fun updateProfile(
            @Header("token") token: String,
            @Part("firstname") firstname: RequestBody,
            @Part("lastname") lastname: RequestBody,
            @Part("dob") dob: RequestBody,
            @Part("email") email: RequestBody,
            @Part("phone") phone: RequestBody
        ): Response<LoginModel>


        @GET("{type}")
        suspend fun getPersonalQuestions(
            @Header("token") token: String, @Path("type") type: String
        ): Response<AboutMeQuestionModel>

        @GET("get-stores")
        suspend fun getNearStore(
            @Header("token") token: String,
            @Query("latitude") latitude: String,
            @Query("longitude") longitude: String,
        ): Response<GetStoreModel>

        @POST("save-user-information")
        suspend fun saveUserInfo(
            @Header("token") token: String, @Body answers: JsonObject
        ): Response<SaveUserQuestionAnswerModel>*/

}