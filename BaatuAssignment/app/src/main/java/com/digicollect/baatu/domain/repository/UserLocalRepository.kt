package com.digicollect.baatu.domain.repository


import com.baatu.assignment.data.model.User
import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.utility.Resource

interface UserLocalRepository {
    suspend fun inserUserData(userItem:UserItem)
}