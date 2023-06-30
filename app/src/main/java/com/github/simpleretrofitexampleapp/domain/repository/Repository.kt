package com.github.simpleretrofitexampleapp.domain.repository

import com.github.simpleretrofitexampleapp.domain.model.Photo

interface Repository {
    suspend fun getPhotos(): List<Photo>
}