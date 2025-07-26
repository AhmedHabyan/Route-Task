package com.example.routetask.data.datasource

import com.example.routetask.data.utils.ApiResult
import com.example.routetask.data.utils.safeCallApi
import com.example.routetask.data.webservice.WebService
import com.example.routetask.domain.contract.data_source.RemoteDataSource
import com.example.routetask.domain.model.Photo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl @Inject constructor(
    private val webservice:WebService
): RemoteDataSource {
    override suspend fun getPhotos(): Photo {
       return webservice.getPhotos().toPhoto()
    }
}