package com.digicollect.baatu.presentation.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.baatu.assignment.data.model.User
import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.R
import com.digicollect.baatu.domain.usecases.GetUserListUseCase
import com.digicollect.baatu.domain.usecases.SaveUserUseCase
import com.digicollect.baatu.utility.Resource
import com.digicollect.baatu.utility.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
        private val application:Application,
        private val getUserListUseCase:GetUserListUseCase,
        private val saveUserUseCase:SaveUserUseCase,
                   ) : ViewModel() {

    internal val getAlbumListApiResponse: MutableLiveData<Resource<User>> = MutableLiveData()

    /*used to get album list*/
    fun getUserData() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (Utils.isNetworkAvaialable(application)) {
                val apiResult = getUserListUseCase.execute()
                getAlbumListApiResponse.postValue(apiResult)
            } else {
                executeElseBlock(getAlbumListApiResponse)
            }
        } catch (e: Exception) {
            showExceptionMessage(e, getAlbumListApiResponse)
        }
    }

    //save user to room database
    fun saveUser(userItem:UserItem) = viewModelScope.launch {
        saveUserUseCase.execute(userItem)
    }

    /*used to exception messages*/
    private fun <T> showExceptionMessage(
        e: Exception,
        apiResponseLiveData: MutableLiveData<Resource<T>>
    ) {
        apiResponseLiveData.postValue(Resource.Error(e.message.toString()))
    }

    /*used - to post internet connection error*/
    private fun <T> executeElseBlock(apiResponse: MutableLiveData<Resource<T>>) {
        apiResponse.postValue(Resource.Error(application.getString(R.string.pls_connect_to_internet)))
    }

    fun clearLivedata() {
        Utils.clearLiveData(getAlbumListApiResponse)
    }


}