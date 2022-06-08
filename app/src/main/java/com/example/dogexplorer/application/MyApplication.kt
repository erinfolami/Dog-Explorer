package com.example.dogexplorer.application

import android.app.Application
import com.example.dogexplorer.di.DaggerAppComponent
import com.example.dogexplorer.di.AppComponent

class MyApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        //This is where we initialize our RetroComponent class
        initAppComponent()
    }

    fun initAppComponent() {
        appComponent =
            DaggerAppComponent.builder().application(this).build()
    }

    fun getAppComponent(): AppComponent = appComponent


}