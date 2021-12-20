package com.example.omdbmovie.repository

import com.example.omdbmovie.api.MovieService
import com.example.omdbmovie.models.DetailedMovie
import com.example.omdbmovie.models.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {
    suspend fun loadMovies(query: String, apiKey: String): List<Movie> {
        return movieService.loadMovies(query, apiKey).movies
    }

    suspend fun loadMovieDetails(imdbID: String, apiKey: String): DetailedMovie {
        return movieService.loadMovieDetail(imdbID, apiKey)
    }
}