package com.example.routetask.domain.contract.repository

import com.example.routetask.data.utils.ApiResult
import com.example.routetask.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepo{
    suspend fun getPhotos(): Flow<ApiResult<Photo>>
}