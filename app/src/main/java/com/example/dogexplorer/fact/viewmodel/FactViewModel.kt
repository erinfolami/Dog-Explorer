package com.example.dogexplorer.fact.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dogexplorer.application.MyApplication
import com.example.dogexplorer.models.DogFactModel
import com.example.dogexplorer.repositories.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FactViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: Repository

    private var liveData: MutableLiveData<DogFactModel?>

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