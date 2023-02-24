package com.codes.githubapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.codes.githubapp.data.cache.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(ownerEntity: UserEntity)

    @Delete
    suspend fun deleteUser(ownerEntity: UserEntity)

}