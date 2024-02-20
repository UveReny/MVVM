package com.example.mvvm.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val Title: String,
    val Year: String?,
    val imdbID: String,
    val Type: String?,
    val Poster: String
)
