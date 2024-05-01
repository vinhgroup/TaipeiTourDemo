package com.example.demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nguyennk.movieapp.repository.TourRepository
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class TourViewModelFactory(private val repository: TourRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TourViewModel::class.java)) {
            return TourViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}