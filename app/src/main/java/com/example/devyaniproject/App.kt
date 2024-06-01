package com.example.devyaniproject

import android.app.Application
import com.example.devyaniproject.myDemo.koinDIMVVM.module.appModule
import com.example.devyaniproject.myDemo.koinDIMVVM.module.repoModule
import com.example.devyaniproject.myDemo.koinDIMVVM.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/*@HiltAndroidApp*/
class App : Application(){


    companion object {
        lateinit var instance: App

        fun getAppContext(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
           androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}