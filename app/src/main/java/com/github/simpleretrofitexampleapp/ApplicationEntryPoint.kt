package com.github.simpleretrofitexampleapp

import android.app.Application
import com.github.simpleretrofitexampleapp.di.AppDIContainer
import com.github.simpleretrofitexampleapp.di.DefaultContainer

//Using it to create DI class once and keep it in here for the whole app lifetime

class ApplicationEntryPoint : Application(){

    lateinit var diContainer: AppDIContainer

    override fun onCreate() {
        super.onCreate()
        diContainer = DefaultContainer()
    }

}