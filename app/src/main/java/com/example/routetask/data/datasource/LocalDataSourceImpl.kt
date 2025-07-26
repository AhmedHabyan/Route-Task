package com.example.routetask.data.datasource

import com.example.routetask.data.database.AppDatabase
import com.example.routetask.data.utils.ApiResult
import com.example.routetask.data.utils.safeCallApi
import com.example.routetask.data.webservice.WebService
import com.example.routetask.domain.contract.data_source.LocalDataSource
import com.example.routetask.domain.model.Photo
import jakarta.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    val appDatabase: AppDatabase
): LocalDataSource {
    override suspend fun getPhotos():Photo {
       return appDatabase.photoDao().getAllPhotos().toPhoto()
    }

    override suspend fun insertPhotos(photo:Photo) {
         appDatabase.photoDao().insertAllPhoto(
             photo.toPhotoEntity()
         )
    }
}