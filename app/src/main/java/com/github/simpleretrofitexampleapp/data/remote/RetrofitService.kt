package com.github.simpleretrofitexampleapp.data.remote

import com.github.simpleretrofitexampleapp.domain.model.Photo
import retrofit2.http.GET

interface RetrofitService {

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}