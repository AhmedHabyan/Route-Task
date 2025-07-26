package com.example.routetask.domain.model

import com.example.routetask.data.database.PhotoEntity

data class Photo(
    val photoUrlList:List<String>?=null
){
    fun toPhotoEntity():PhotoEntity{
        return PhotoEntity(
            photoUrl = photoUrlList?.map { it }
        )
    }
}