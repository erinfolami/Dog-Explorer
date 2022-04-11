package com.example.dogexplorer.models

import com.google.gson.annotations.SerializedName

data class DogFactModel(
    @SerializedName("fact")
    val fact: String
    )
