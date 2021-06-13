package com.moviechart.utils.fortesting.viewmodel

import androidx.lifecycle.MutableLiveData
import com.moviechart.data.source.local.room.shows.TvShowsRoomEntity
import com.moviechart.utils.fortesting.repository.FakeFavoriteShowsRepository

class FakeShowsStarredViewModel {

    private var data: MutableLiveData<ArrayList<TvShowsRoomEntity>>
    private var repository: FakeFavoriteShowsRepository = FakeFavoriteShowsRepository()

    init {
        data = repository.readAllShows()
    }

    fun readAllShows(): MutableLiveData<ArrayList<TvShowsRoomEntity>> {
        return data
    }

    fun addShow(){
        repository.addShows()
    }

    fun delShowById(){
        repository.delShowById()
    }

}