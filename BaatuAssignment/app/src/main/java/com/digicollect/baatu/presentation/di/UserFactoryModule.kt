package com.digicollect.baatu.presentation.di

import android.app.Application

import com.digicollect.baatu.domain.usecases.GetUserListUseCase
import com.digicollect.baatu.domain.usecases.SaveUserUseCase
import com.digicollect.baatu.presentation.ui.UserViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserFactoryModule {
    @Provides
    fun providesViewModelFactory(
            application: Application,
            getUserListUseCase:GetUserListUseCase,
            saveUserUseCase:SaveUserUseCase,
    ):UserViewModelFactory {
        return UserViewModelFactory(
            application,getUserListUseCase,saveUserUseCase
                                   )
    }
}