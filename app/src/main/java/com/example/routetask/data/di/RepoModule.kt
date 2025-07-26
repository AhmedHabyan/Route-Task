package com.example.routetask.data.di

import com.example.routetask.data.datasource.LocalDataSourceImpl
import com.example.routetask.data.datasource.RemoteDataSourceImpl
import com.example.routetask.data.repository_impl.PhotosRepoImpl
import com.example.routetask.data.utils.NetworkMonitor
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.contract.data_source.RemoteDataSource
import com.example.routetask.domain.contract.repository.PhotosRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun providePhotosRepo(remoteDataSource: RemoteDataSource,
                          localDataSource: LocalDataSource,
                          networkMonitor: NetworkMonitor
    ): PhotosRepo {
        return PhotosRepoImpl(remoteDataSource,
            localDataSource,
            networkMonitor)
    }
}