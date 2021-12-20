package com.example.omdbmovie.models

import com.squareup.moshi.Json

data class DetailedMovie(
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "Released") val released: String,
    val imdbID: String,
    @Json(name = "imdbRating") val rating: String,
    @Json(name = "Poster") val posterUrl: String

)
