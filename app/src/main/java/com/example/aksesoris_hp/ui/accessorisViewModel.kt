package com.example.aksesoris_hp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.aksesoris_hp.model.accessoris
import com.example.aksesoris_hp.repository.aksesorisRepository
import kotlinx.coroutines.launch

class accessorisViewModel(private val repository: aksesorisRepository): ViewModel() {
    val allAccessoris: LiveData<List<accessoris>> =repository.allAksesoris.asLiveData()

    fun insert(accessoris: accessoris) = viewModelScope.launch {
        repository.insertAksesoris(accessoris)
    }
    fun delete(accessoris: accessoris)=viewModelScope.launch {
        repository.deleteAksesoris(accessoris)
    }
    fun update(accessoris: accessoris)=viewModelScope.launch {
        repository.updateAksesoris(accessoris)
    }
}

class AccessorisViewModelFactory(private val repository: aksesorisRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(accessorisViewModel::class.java)){
            return accessorisViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}