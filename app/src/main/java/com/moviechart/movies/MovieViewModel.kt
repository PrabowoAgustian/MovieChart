package com.moviechart.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.moviechart.data.source.local.MovieEntity
import com.moviechart.data.source.Repository

class MovieViewModel(private val repository: Repository):ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> {
        return repository.getLocalMovies()
    }
}