package com.example.dogexplorer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dogexplorer.R
import com.example.dogexplorer.databinding.ActivityMainBinding
import com.example.dogexplorer.di.DaggerRetroComponent
import com.example.dogexplorer.models.DogFactModel
import com.example.dogexplorer.services.ApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initViewModel()

        binding.dogFactBtn.setOnClickListener {
            makeApiCall()
        }


    }


    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.getLiveDataObserver().observe(this) { response ->
            if (response != null) {
            binding.dogFactTextView.text = response.text
            } else {
                Log.d("response", "error getting the data")

            }
        }
    }

    private fun makeApiCall() {
        mainActivityViewModel.getDogFact()
    }


}