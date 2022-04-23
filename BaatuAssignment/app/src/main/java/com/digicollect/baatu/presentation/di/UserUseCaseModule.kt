package com.digicollect.baatu.presentation.di

import com.digicollect.baatu.domain.repository.UserLocalRepository
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.domain.usecases.GetUserListUseCase
import com.digicollect.baatu.domain.usecases.SaveUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserUseCaseModule {

    @Provides
    fun providesUserRepo(userRepository: UserRepository): GetUserListUseCase {
        return GetUserListUseCase(userRepository)
    }

    @Provides
    fun providesUserLocalRepo(userLocalRepository:UserLocalRepository): SaveUserUseCase {
        return SaveUserUseCase(userLocalRepository)
    }
}