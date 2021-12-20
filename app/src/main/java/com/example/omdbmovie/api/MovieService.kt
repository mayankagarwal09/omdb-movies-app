package com.example.omdbmovie.api

import com.example.omdbmovie.models.ApiResponse
import com.example.omdbmovie.models.DetailedMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/")
    suspend fun loadMovies(
        @Query("s") search: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/")
    suspend fun loadMovieDetail(
        @Query("i") imdbID: String,
        @Query("apiKey") apiKey: String,
    ): DetailedMovie


}