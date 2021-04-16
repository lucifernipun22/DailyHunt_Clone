package com.example.dailyhunt_clone.Data

import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class NewsResponseDTO(

	@field:SerializedName("comments")
	val comments: String? = null,

	@field:SerializedName("imageurl")
	val imageurl: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("createdon")
	val createdon: String? = null,

	@field:SerializedName("likes")
	val likes: String? = null
)