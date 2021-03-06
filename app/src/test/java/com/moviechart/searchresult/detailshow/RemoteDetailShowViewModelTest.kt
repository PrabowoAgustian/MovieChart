package com.moviechart.searchresult.detailshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.moviechart.data.source.Repository
import com.moviechart.data.source.remote.SearchDetailShowResponse
import com.moviechart.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDetailShowViewModelTest {

    private lateinit var viewModel: DetailShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var detailShowObserver: Observer<SearchDetailShowResponse>

    @Before
    fun setUp(){
        viewModel = DetailShowViewModel(repository)
    }

    @Test
    fun getShowById() {
        val dummyDetailShows = DataDummy.generateFakeShowDetailResponse()
        val detailShowExpectation = MutableLiveData<SearchDetailShowResponse>()
        detailShowExpectation.value = dummyDetailShows

        `when`(repository.getRemoteShowDetailsById("123")).thenReturn(detailShowExpectation)
        val detailShowReality = viewModel.getShowById("123")
        verify(repository).getRemoteShowDetailsById("123")
        assertNotNull(detailShowReality.value)
        assertEquals(detailShowExpectation.value,detailShowReality.value)

        viewModel.getShowById("123").observeForever(detailShowObserver)
        verify(detailShowObserver).onChanged(dummyDetailShows)
    }
}