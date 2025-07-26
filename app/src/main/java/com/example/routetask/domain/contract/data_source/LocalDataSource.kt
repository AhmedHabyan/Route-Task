package com.example.routetask.domain.contract.data_source

import com.example.routetask.data.database.PhotoEntity
import com.example.routetask.data.utils.ApiResult
import com.example.routetask.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getPhotos():Photo
    suspend fun insertPhotos(photo:Photo)
}