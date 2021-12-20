package com.example.omdbmovie.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omdbmovie.di.modules.NetworkModule
import com.example.omdbmovie.models.DetailedMovie
import com.example.omdbmovie.models.Movie
import com.example.omdbmovie.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val movieRepository: MovieRepository
) : ViewModel() {

    private val _movieList = MutableLiveData<List<Movie>?>()
    private val _movieDetails = MutableLiveData<DetailedMovie?>()

    val movieList: LiveData<List<Movie>?>
        get() = _movieList
    val movieDetails: LiveData<DetailedMovie?>
        get() = _movieDetails


    fun loadMovieList(query: String) {
        viewModelScope.launch {
            val response = movieRepository.loadMovies(query, NetworkModule.API_KEY)
            _movieList.value = response
        }
    }

    fun loadMovieDetails(imdbID: String) {
        viewModelScope.launch {
            val response = movieRepository.loadMovieDetails(imdbID, NetworkModule.API_KEY)
            Log.d(javaClass.simpleName, "movieDetails: $response")
            _movieDetails.value = response
        }
    }

    fun resetMovieDetail() {
        _movieDetails.value = null
    }

}