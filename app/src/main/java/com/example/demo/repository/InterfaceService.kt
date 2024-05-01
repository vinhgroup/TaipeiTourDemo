package com.nguyennk.movieapp.repository

import quicktype.DataInfor
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceService {

    @Headers("Accept: application/json")
    @GET("open-api/{lang}/Attractions/All")
    suspend fun getTour(@Path("lang") lang: String, @Query("page") page: Int): DataInfor
}