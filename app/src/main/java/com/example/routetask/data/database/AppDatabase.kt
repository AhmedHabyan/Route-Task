package com.example.routetask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [PhotoEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun photoDao():PhotoDao
}