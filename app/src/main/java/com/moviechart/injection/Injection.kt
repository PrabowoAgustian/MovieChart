package com.moviechart.injection

import com.moviechart.data.source.remote.RemoteDataSource
import com.moviechart.data.source.Repository
import com.moviechart.data.source.local.LocalDataSource

object Injection {
    fun provideRepository(): Repository {
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance()
        return Repository.getInstance(remoteDataSource,localDataSource)
    }
}