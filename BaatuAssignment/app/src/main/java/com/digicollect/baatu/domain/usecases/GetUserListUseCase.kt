package com.digicollect.baatu.domain.usecases

import com.baatu.assignment.data.model.User
import com.digicollect.baatu.domain.repository.UserRepository
import com.digicollect.baatu.utility.Resource

class GetUserListUseCase(private val userRepository:UserRepository) {
    suspend fun execute():Resource<User> {
        return userRepository.getUserList()
    }
}