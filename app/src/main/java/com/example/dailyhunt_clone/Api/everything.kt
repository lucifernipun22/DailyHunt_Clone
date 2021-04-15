package com.example.dailyhunt_clone.Api


import com.google.gson.annotations.SerializedName

data class everything(
    @SerializedName("articles")
    var articles: List<Article>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?
)