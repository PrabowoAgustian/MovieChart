package com.moviechart.utils.fortesting.viewmodel

import androidx.lifecycle.MutableLiveData
import com.moviechart.data.source.local.room.movies.MoviesRoomEntity
import com.moviechart.utils.fortesting.repository.FakeFavoriteMovieRepository

class FakeMovieStarredViewModel () {

    private var data: MutableLiveData<ArrayList<MoviesRoomEntity>>
    private var repository: FakeFavoriteMovieRepository = FakeFavoriteMovieRepository()

    init {
        data = repository.getReadAllMovies()
    }

    fun getReadAllMovies(): MutableLiveData<ArrayList<MoviesRoomEntity>> {
        return data
    }

    fun addMovie(){
        repository.addMovie()
    }

    fun delMovieById(){
        repository.delMovieById()
    }

}