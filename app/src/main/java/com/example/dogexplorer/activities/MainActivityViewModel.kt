package com.example.dogexplorer.activities

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogexplorer.application.MyApplication
import com.example.dogexplorer.di.DaggerRetroComponent
import com.example.dogexplorer.di.ServiceBuilderModule
import com.example.dogexplorer.models.DogFactModel
import com.example.dogexplorer.repositories.Repository
import com.example.dogexplorer.services.ApiService
import kotlinx.coroutines.launch
import javax.inject.Inject

//class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
class MainActivityViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: Repository

    private lateinit var liveData: MutableLiveData<DogFactModel?>

    init {
        // Make Dagger instantiate @Inject fields in MainActivityViewModel
        (application as MyApplication).getRetroComponent().inject(this)

        liveData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<DogFactModel?> {
        return liveData
    }


    fun getDogFact() {
        //Api Query Parameter
        val filter = HashMap<String, String>()
        filter["animal_type"] = "cat"
        filter["amount"] = "1"

        viewModelScope.launch {
            val dogFact = repository.getDogFact(filter)
            liveData.postValue(dogFact)
        }


    }

}