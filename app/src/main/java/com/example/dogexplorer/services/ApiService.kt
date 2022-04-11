package com.example.dogexplorer.services

import com.example.dogexplorer.models.DogFactModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v1/resources/dogs")
    suspend fun getDogFact(@Query("index") index: String): Response<List<DogFactModel>>

}