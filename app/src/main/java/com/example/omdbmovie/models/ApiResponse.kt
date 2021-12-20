package com.example.omdbmovie.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "Search") val movies: List<Movie>,
    @Json(name = "totalResults") val total: Long,
    @Json(name = "Response") val response: String
)
