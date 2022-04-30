package com.example.dogexplorer.di

import com.example.dogexplorer.services.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ServiceBuilderModule {
    val baseUrl = "https://cat-fact.herokuapp.com"

 
    @Singleton
    @Provides
    fun retrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}