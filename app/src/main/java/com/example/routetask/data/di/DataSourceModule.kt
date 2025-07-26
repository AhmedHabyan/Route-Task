package com.example.routetask.data.di

import com.example.routetask.data.database.AppDatabase
import com.example.routetask.data.datasource.LocalDataSourceImpl
import com.example.routetask.data.datasource.RemoteDataSourceImpl
import com.example.routetask.data.webservice.WebService
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.contract.data_source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(webService: WebService):RemoteDataSource{
        return RemoteDataSourceImpl(webService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(appDatabase: AppDatabase): LocalDataSource {
        return LocalDataSourceImpl(appDatabase)
    }
}