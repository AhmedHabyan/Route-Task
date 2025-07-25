package com.example.routetask.domain.contract.data_source

import com.example.routetask.data.utils.ApiResult
import com.example.routetask.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getPhotos(): Flow<ApiResult<Photo>>
}