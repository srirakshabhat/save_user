package com.digicollect.baatu.domain.repository


import com.baatu.assignment.data.model.User
import com.digicollect.baatu.utility.Resource

interface UserRepository {
    suspend fun getUserList():Resource<User>
}