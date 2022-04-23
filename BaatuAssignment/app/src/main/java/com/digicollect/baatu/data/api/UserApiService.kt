package com.digicollect.baatu.data.api

import com.baatu.assignment.data.model.User
import com.digicollect.baatu.utility.UserConstant
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {

    /* to get all user data*/
    @GET(UserConstant.API_GET_ALL_USERS)
    suspend fun getUserList(): Response<User>

}