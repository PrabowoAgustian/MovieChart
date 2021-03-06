package com.moviechart.searchresult.detailshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviechart.data.source.FavoriteShowRepository
import com.moviechart.data.source.local.room.shows.TvShowRoomDatabase
import com.moviechart.data.source.local.room.shows.TvShowsRoomEntity
import com.moviechart.utils.EspressoIdlingResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowStarredViewModel(application: Application): ViewModel() {

    val readAllShows: LiveData<List<TvShowsRoomEntity>>
    private val repository: FavoriteShowRepository

    init {
        val showDao = TvShowRoomDatabase.getDatabase(application).tvShowsStarredDao()
        repository = FavoriteShowRepository(showDao)
        readAllShows = repository.readAllShows
    }

    fun addShow(show: TvShowsRoomEntity){
        EspressoIdlingResources.increment()
        viewModelScope.launch(Dispatchers.IO){
            repository.addShows(show)
        }
        EspressoIdlingResources.decrement()
    }

    fun delShowById(showId: Int){
        EspressoIdlingResources.increment()
        viewModelScope.launch(Dispatchers.IO){
            repository.delShowById(showId)
        }
        EspressoIdlingResources.decrement()
    }


}