package com.example.dogexplorer.application

import android.app.Application
import com.example.dogexplorer.di.DaggerRetroComponent
import com.example.dogexplorer.di.RetroComponent
import com.example.dogexplorer.di.ServiceBuilderModule

class MyApplication : Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        //This is where we initialize our RetroComponent class
        initRetroComponent()
    }

    fun initRetroComponent() {
        retroComponent =
            DaggerRetroComponent.builder().serviceBuilderModule(ServiceBuilderModule).build()
    }

    fun getRetroComponent(): RetroComponent = retroComponent


}