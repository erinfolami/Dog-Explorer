package com.example.dogexplorer.di

import com.example.dogexplorer.fact.viewmodel.FactViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ServiceBuilderModule::class])
interface RetroComponent {
    //Field Injection
    fun inject(factViewModel: FactViewModel)
}