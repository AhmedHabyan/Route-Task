package com.example.routetask.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.routetask.domain.model.Photo


@Entity(tableName = "photo")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo("photo")
    val photoUrl:List<String>?=null

){
    fun toPhoto():Photo{
        return Photo(
            photoUrlList = photoUrl
        )
    }
}