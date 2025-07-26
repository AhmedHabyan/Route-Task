package com.example.routetask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {

    @Query("select * from photo")
    fun getAllPhotos():PhotoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPhoto(photos:PhotoEntity)
}