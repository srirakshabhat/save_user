package com.digicollect.baatu.domain.repositoryImpl

import com.baatu.assignment.data.model.User
import com.digicollect.baatu.data.api.UserApiService
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.utility.Resource
import com.digicollect.baatu.utility.Utils

class UserRepositoryImpl(private val userApiService:UserApiService) : UserRepository {
    override suspend fun getUserList():Resource<User> {
        return Utils.responseToResource(userApiService.getUserList())
    }
}