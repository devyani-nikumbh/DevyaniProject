package com.example.devyaniproject.myDemo.koinDIMVVM.module




import com.example.devyaniproject.myDemo.koinDIMVVM.data.repository.MainRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repoModule = module {
    singleOf(::MainRepository)
}