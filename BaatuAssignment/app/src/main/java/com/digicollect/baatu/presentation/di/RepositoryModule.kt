package com.digicollect.baatu.presentation.di


import com.digicollect.baatu.data.api.UserApiService
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.domain.repositoryImpl.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesUserRepository(userApiService:UserApiService):UserRepository {
        return UserRepositoryImpl(userApiService)
    }
}