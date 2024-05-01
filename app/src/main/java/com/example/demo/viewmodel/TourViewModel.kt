package com.example.demo.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nguyennk.movieapp.repository.TourRepository
import kotlinx.coroutines.launch
import quicktype.DataInfor

class TourViewModel(private val repository: TourRepository) : ViewModel(),
    ViewModelProvider.Factory {
    private val repo = TourRepository()
    private val _movieShowTour = MutableLiveData<DataInfor>()
    val listTour: LiveData<DataInfor> = _movieShowTour

//    init {
//        loadPhimLe()
//    }

    fun loadTour(lang: String) {
        viewModelScope.launch {
            try {
                val phimLe = repo.getTour(lang, 1)
                _movieShowTour.value = phimLe
            } catch (e: Exception) {
                // Handle error appropriately, such as showing an error message
                Log.e(TAG, "Failed to load TV shows", e)
            }
        }
    }
}