package com.codes.githubapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codes.githubapp.data.cache.entity.FollowingEntity

@Dao
interface FollowingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFollowing(followingEntity: List<FollowingEntity>)

    @Query("DELETE FROM following_table")
    suspend fun deleteFollowing(followingEntity: List<FollowingEntity>)

    @Query("SELECT * FROM following_table")
    suspend fun getFollowing(): List<FollowingEntity>
}
