package com.digicollect.baatu.presentation.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.digicollect.baatu.domain.usecases.GetUserListUseCase
import com.digicollect.baatu.domain.usecases.SaveUserUseCase

class UserViewModelFactory(
        private val application:Application,
        private val getUserListUseCase:GetUserListUseCase,
        private val saveUserUseCase:SaveUserUseCase,
                          ) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass:Class<T>):T {
        return UserViewModel(
            application,getUserListUseCase,saveUserUseCase) as T
    }

}