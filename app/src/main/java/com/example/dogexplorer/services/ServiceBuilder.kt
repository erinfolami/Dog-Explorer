package com.example.dogexplorer.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    val baseUrl = "https://dog-facts-api.herokuapp.com"


    fun retrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofitInstance().create(serviceType)
    }

}