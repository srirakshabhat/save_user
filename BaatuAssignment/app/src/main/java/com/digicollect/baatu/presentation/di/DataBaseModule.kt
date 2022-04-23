package com.digicollect.baatu.presentation.di

import android.app.Application
import androidx.room.Room
import com.digicollect.baatu.data.db.UserDAO
import com.digicollect.baatu.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(app, UserDatabase::class.java, "users_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase:UserDatabase): UserDAO {
        return userDatabase.getUserDao()
    }


}