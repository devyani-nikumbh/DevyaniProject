package com.example.devyaniproject.myDemo.koinDIMVVM.module

import android.content.Context
import com.example.devyaniproject.myDemo.koinDIMVVM.data.api.ApiHelper
import com.example.devyaniproject.myDemo.koinDIMVVM.data.api.ApiHelperImpl
import com.example.devyaniproject.myDemo.koinDIMVVM.data.api.ApiService
import com.example.devyaniproject.myDemo.koinDIMVVM.utils.NetworkHelper
import com.example.devyaniproject.myDemo.koinDIMVVM.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), Constant.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideOkHttpClient() = if (true) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)