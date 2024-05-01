package com.nguyennk.movieapp.repository

import quicktype.DataInfor


private val apiService = RetrofitObject.apiService
class TourRepository {

    suspend fun getTour(lang: String, page: Int): DataInfor {
        return apiService.getTour(lang,  page) // Assuming TVService has appropriate endpoints and data models
    }
}