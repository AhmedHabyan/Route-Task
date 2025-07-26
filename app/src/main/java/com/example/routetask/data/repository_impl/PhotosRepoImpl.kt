package com.example.routetask.data.repository_impl


import android.Manifest
import android.util.Log
import androidx.annotation.RequiresPermission
import com.example.routetask.data.utils.ApiResult
import com.example.routetask.data.utils.NetworkMonitor
import com.example.routetask.data.utils.NetworkUtils
import com.example.routetask.data.utils.safeCallApi
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.contract.data_source.RemoteDataSource
import com.example.routetask.domain.contract.repository.PhotosRepo
import com.example.routetask.domain.model.Photo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class PhotosRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val networkMonitor: NetworkMonitor
): PhotosRepo {
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override suspend fun getPhotos(): Flow<ApiResult<Photo>> {

        if(networkMonitor.isConnected()){
            val photo = remoteDataSource.getPhotos()
            localDataSource.insertPhotos(photo)
            return safeCallApi { photo}
        }


        else{
            return safeCallApi{localDataSource.getPhotos()}
        }



//    return localDataSource.getPhotos()
        //else take from local datasource
    }
}