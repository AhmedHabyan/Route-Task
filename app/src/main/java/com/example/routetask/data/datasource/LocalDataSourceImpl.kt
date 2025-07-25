package com.example.routetask.data.datasource

import com.example.routetask.data.utils.ApiResult
import com.example.routetask.data.utils.safeCallApi
import com.example.routetask.data.webservice.WebService
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.model.Photo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl @Inject constructor(
    val webservice:WebService
): LocalDataSource {
    override suspend fun getPhotos(): Flow<ApiResult<Photo>> {
       return safeCallApi { webservice.getPhotos().toPhoto() }
    }
}