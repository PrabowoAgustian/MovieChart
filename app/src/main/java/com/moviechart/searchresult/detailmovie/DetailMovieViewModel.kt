package com.moviechart.searchresult.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.moviechart.data.source.Repository
import com.moviechart.data.source.remote.SearchDetailMovieResponse

class DetailMovieViewModel(private val repository: Repository): ViewModel() {

    fun getMovieById(id: String): LiveData<SearchDetailMovieResponse> {
        return repository.getRemoteMovieDetailsById(id)
    }

}