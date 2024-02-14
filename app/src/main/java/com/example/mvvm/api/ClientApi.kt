package com.example.mvvm.api

import retrofit2.http.GET

interface ClientApi {
    @GET("/")
    suspend fun fetchContents(): String

    @GET("https://omdbapi.com/?apikey=1dbc7755&s=Egg")
    suspend fun fetchResponse(): String
}