package com.example.routetask.data.repository_impl


import com.example.routetask.data.utils.ApiResult
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.contract.data_source.RemoteDataSource
import com.example.routetask.domain.contract.repository.PhotosRepo
import com.example.routetask.domain.model.Photo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class PhotosRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): PhotosRepo {
    override suspend fun getPhotos(): Flow<ApiResult<Photo>> {
        //if there is internet connection take from remote datasource

        return remoteDataSource.getPhotos()


        //else take from local datasource
    }
}