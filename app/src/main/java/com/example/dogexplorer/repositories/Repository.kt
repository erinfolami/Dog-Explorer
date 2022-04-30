package com.example.dogexplorer.repositories

import android.util.Log
import com.example.dogexplorer.models.DogFactModel
import com.example.dogexplorer.services.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDogFact(filter: HashMap<String, String>): DogFactModel? {
        val response = apiService.getDogFact(filter)
        Log.d("response status: ", "response status" + response.isSuccessful)
        if (response.isSuccessful) {
            return response.body()
        }
        return null

    }
}