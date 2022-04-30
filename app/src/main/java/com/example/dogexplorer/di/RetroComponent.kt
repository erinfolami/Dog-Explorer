package com.example.dogexplorer.di

import com.example.dogexplorer.activities.MainActivityViewModel
import com.example.dogexplorer.repositories.Repository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ServiceBuilderModule::class])
interface RetroComponent {
    //Field Injection
    fun inject(mainActivityViewModel: MainActivityViewModel)
}