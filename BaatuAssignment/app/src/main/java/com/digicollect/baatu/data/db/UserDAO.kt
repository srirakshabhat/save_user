package com.digicollect.baatu.data.db

import androidx.room.*
import com.baatu.assignment.data.model.User
import com.baatu.assignment.data.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userItem:UserItem)
}