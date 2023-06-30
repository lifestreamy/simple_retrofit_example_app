package com.github.simpleretrofitexampleapp.di

import com.github.simpleretrofitexampleapp.domain.repository.Repository


interface AppDIContainer {
    val repository: Repository
}


