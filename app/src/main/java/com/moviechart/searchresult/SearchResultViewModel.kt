package com.moviechart.searchresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.moviechart.data.source.remote.MoviesItem
import com.moviechart.data.source.Repository
import com.moviechart.data.source.remote.ShowsItem

class SearchResultViewModel(private val repository: Repository): ViewModel() {

    fun getMovies(search: String): LiveData<List<MoviesItem>> {
        return repository.getRemoteMovies(search)
    }

    fun getStatusMovies(): LiveData<Boolean>{
        return repository.getRemoteLoadingStatusMovies()
    }

    fun getShows(search: String): LiveData<List<ShowsItem>>{
        return repository.getRemoteShows(search)
    }

    fun getStatusShows(): LiveData<Boolean>{
        return repository.getRemoteLoadingStatusShows()
    }

}