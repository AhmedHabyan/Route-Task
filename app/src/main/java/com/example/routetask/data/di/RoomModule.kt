package com.example.routetask.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.routetask.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext: Context):AppDatabase{
       return Room.databaseBuilder(
           applicationContext,
           klass = AppDatabase::class.java,
           name = "db-photo",
       ).build()
    }
}