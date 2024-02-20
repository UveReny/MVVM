package com.example.mvvm.api

import com.example.mvvm.model.SearchResponse
import retrofit2.http.GET

interface ClientApi {
    @GET("/")
    suspend fun fetchHtml(): String

    @GET("https://omdbapi.com/?apikey=1dbc7755&s=Egg")
    suspend fun fetchContents(): String

    @GET("https://omdbapi.com/?apikey=1dbc7755&s=Egg")
    suspend fun fetchResponse(): SearchResponse
}