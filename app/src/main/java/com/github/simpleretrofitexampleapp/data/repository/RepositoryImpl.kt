package com.github.simpleretrofitexampleapp.data.repository

import com.github.simpleretrofitexampleapp.data.remote.RetrofitService
import com.github.simpleretrofitexampleapp.domain.model.Photo
import com.github.simpleretrofitexampleapp.domain.repository.Repository

class RepositoryImpl(
    private val retrofitService: RetrofitService
) : Repository {
    override suspend fun getPhotos(): List<Photo> = retrofitService.getPhotos()

}