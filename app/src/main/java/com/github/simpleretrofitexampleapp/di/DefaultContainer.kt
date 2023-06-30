package com.github.simpleretrofitexampleapp.di

import com.github.simpleretrofitexampleapp.data.remote.RetrofitService
import com.github.simpleretrofitexampleapp.data.repository.RepositoryImpl
import com.github.simpleretrofitexampleapp.domain.repository.Repository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class DefaultContainer : AppDIContainer {

    //Using a simple backend server provided by google in one of the code-labs
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"


    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    override val repository: Repository by lazy {
        RepositoryImpl(retrofitService)
    }

}