package com.moviechart.utils.fortesting.repository

import androidx.lifecycle.MutableLiveData
import com.moviechart.data.source.local.room.movies.MoviesRoomEntity
import com.moviechart.utils.DataDummy

class FakeFavoriteMovieRepository() {

    private var data: MutableLiveData<ArrayList<MoviesRoomEntity>>

    init {
        val movies = DataDummy.getFakeMovieRoomDatabase()
        data = MutableLiveData<ArrayList<MoviesRoomEntity>>()
        data.value = movies
    }

    fun getReadAllMovies(): MutableLiveData<ArrayList<MoviesRoomEntity>> {
        return data
    }

    fun addMovie() {
        data.value?.add(DataDummy.getMovieRoomEntity())
    }

    fun delMovieById() {
        data.value?.removeAt(0)
    }
}