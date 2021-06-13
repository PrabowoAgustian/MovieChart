package com.moviechart.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.moviechart.data.source.Repository
import com.moviechart.data.source.local.MovieEntity
import com.moviechart.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var mainViewModel: MovieViewModel
    private lateinit var dataDummy: DataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var moviesObserver: Observer<List<MovieEntity>>

    @Before
    fun init(){
        mainViewModel = MovieViewModel(repository)
        dataDummy = DataDummy
    }

    @Test
    fun getMovies() {
        //Expectation
        val expectedMovies = dataDummy.generateMovies()
        val movieExpecation = MutableLiveData<List<MovieEntity>>()
        movieExpecation.value = expectedMovies
        //Reality
        `when`(repository.getLocalMovies()).thenReturn(movieExpecation)
        val movieReality = mainViewModel.getMovies()
        verify(repository).getLocalMovies()
        assertNotNull(movieReality.value)
        assertEquals(movieExpecation.value,movieReality.value)

        mainViewModel.getMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(expectedMovies)
    }
}