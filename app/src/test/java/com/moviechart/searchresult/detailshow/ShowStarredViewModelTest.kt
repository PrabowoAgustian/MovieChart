package com.moviechart.searchresult.detailshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.moviechart.data.source.local.room.shows.TvShowsRoomEntity
import com.moviechart.utils.DataDummy
import com.moviechart.utils.fortesting.viewmodel.FakeShowsStarredViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ShowStarredViewModelTest {
    private lateinit var dataDummy: DataDummy
    private lateinit var viewModel: FakeShowsStarredViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsObserver: Observer<ArrayList<TvShowsRoomEntity>>

    @Before
    fun init(){
        viewModel = FakeShowsStarredViewModel()
        dataDummy = DataDummy
    }

    @Test
    fun getReadAllShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        //Actual
        val listShowsActual = viewModel.readAllShows()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        viewModel.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun addShow() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows
        listShowsExpectation.value!!.add(dataDummy.getTvShowRoomEntity())

        //Actual
        val listShowsActual = viewModel.readAllShows()
        viewModel.addShow()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        viewModel.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)

    }

    @Test
    fun delShowById() {
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows
        listShowsExpectation.value!!.removeAt(0)

        //Actual
        val listShowsActual = viewModel.readAllShows()
        viewModel.delShowById()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        viewModel.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }
}