package com.tejeet.retrofitkotlin

import com.example.dailyhunt_clone.Data.NewsResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/api/news")
    fun getNews() : Call<List<NewsResponseDTO>>
}