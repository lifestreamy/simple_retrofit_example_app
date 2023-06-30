package com.github.simpleretrofitexampleapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Photo Entity

@Serializable
data class Photo(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)

