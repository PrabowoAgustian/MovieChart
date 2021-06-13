package com.moviechart.data.source

import androidx.lifecycle.LiveData
import com.moviechart.data.source.local.room.shows.TvShowsRoomEntity
import com.moviechart.data.source.local.room.shows.TvShowsStarredDao
import com.moviechart.utils.EspressoIdlingResources

class FavoriteShowRepository(private val showDao: TvShowsStarredDao) {

    val readAllShows: LiveData<List<TvShowsRoomEntity>> = showDao.getAllShows()

    fun addShows(show: TvShowsRoomEntity){
        EspressoIdlingResources.increment()
        showDao.insert(show)
        EspressoIdlingResources.decrement()
    }

    fun delShowById(showId: Int){
        EspressoIdlingResources.increment()
        showDao.deleteByShowId(showId)
        EspressoIdlingResources.decrement()
    }


}