package com.digicollect.baatu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.baatu.assignment.data.model.UserItem

@Database(
    entities = [UserItem::class],
    version = 2,
    exportSchema = false
)

abstract  class UserDatabase : RoomDatabase(){
    abstract fun getUserDao():UserDAO
}

