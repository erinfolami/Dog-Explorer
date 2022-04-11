package com.example.dogexplorer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dogexplorer.R
import com.example.dogexplorer.services.ApiService
import com.example.dogexplorer.services.ServiceBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val DogFactApi = ServiceBuilder.buildService(ApiService::class.java)

        //launching A new coroutine
        GlobalScope.launch {
            val result = DogFactApi.getDogFact("1")
            if (result != null) {
                // Checking the results
                var facts = result.body()

                if (facts != null) {
                    for (fact in facts) {
                        Log.d("ayush: ", fact.fact)
                    }

                }
            }
//            Log.d("ayush: ", result.body().toString())

        }
    }
}