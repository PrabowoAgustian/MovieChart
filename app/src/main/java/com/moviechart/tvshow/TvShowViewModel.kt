package com.moviechart.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.moviechart.data.source.local.TVShowEntity
import com.moviechart.data.source.Repository

class TvShowViewModel(private val repository: Repository):ViewModel() {

    fun getTvShows(): LiveData<List<TVShowEntity>> {
        return repository.getLocalShows()
    }
}