package com.example.dogexplorer.services

import com.example.dogexplorer.models.DogFactModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("/facts/random")
    suspend fun getDogFact(@QueryMap filter: HashMap<String, String>): Response<DogFactModel>

}