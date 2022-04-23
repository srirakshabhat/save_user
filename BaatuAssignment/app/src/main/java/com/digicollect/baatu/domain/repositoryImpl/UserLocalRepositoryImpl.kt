package com.digicollect.baatu.domain.repositoryImpl

import com.baatu.assignment.data.model.User
import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.data.api.UserApiService
import com.digicollect.baatu.data.db.UserDAO
import com.digicollect.baatu.domain.repository.UserLocalRepository
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.utility.Resource
import com.digicollect.baatu.utility.Utils

class UserLocalRepositoryImpl(private val userDAO:UserDAO) : UserLocalRepository {
    override suspend fun inserUserData(userItem:UserItem){
        return userDAO.insert(userItem)
    }
}