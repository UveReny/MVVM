package com.example.mvvm.api

import retrofit2.http.GET

interface ClientApi {
    @GET("/")
    suspend fun fetchContents(): String
}