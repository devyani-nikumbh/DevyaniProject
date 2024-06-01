package com.example.devyaniproject.myDemo.koinDIMVVM.module


import com.example.devyaniproject.myDemo.koinDIMVVM.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainViewModel)
}