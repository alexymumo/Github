package com.codes.githubapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codes.githubapp.data.cache.entity.FollowersEntity

@Dao
interface FollowersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFollowers(followersEntity: List<FollowersEntity>)

    @Query("DELETE FROM followers_table")
    suspend fun deleteFollowers(followersEntity: FollowersEntity)

    @Query("SELECT * FROM followers_table")
    suspend fun getFollowers(): List<FollowersEntity>

}