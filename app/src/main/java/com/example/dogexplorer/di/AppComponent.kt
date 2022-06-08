package com.example.dogexplorer.di

import android.app.Application
import com.example.dogexplorer.fact.viewmodel.FactViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    //Field Injection
    fun inject(factViewModel: FactViewModel)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}