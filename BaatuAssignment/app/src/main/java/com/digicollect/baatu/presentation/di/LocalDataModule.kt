package com.digicollect.baatu.presentation.di

import com.digicollect.baatu.data.db.UserDAO
import com.digicollect.baatu.domain.repository.UserLocalRepository
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.domain.repositoryImpl.UserLocalRepositoryImpl
import com.digicollect.baatu.domain.repositoryImpl.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(userDAO:UserDAO):UserLocalRepository{
      return UserLocalRepositoryImpl(userDAO)
    }

}













