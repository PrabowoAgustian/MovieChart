package com.moviechart.searchresult.detailshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.moviechart.data.source.Repository
import com.moviechart.data.source.remote.SearchDetailShowResponse

class DetailShowViewModel(private val repository: Repository): ViewModel() {

    fun getShowById(id: String): LiveData<SearchDetailShowResponse> {
        return repository.getRemoteShowDetailsById(id)
    }

}