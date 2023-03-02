package com.codes.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codes.cache.entity.RepositoriesEntity

@Dao
interface RepositoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositoriesEntity: List<RepositoriesEntity>)
    @Query("DELETE FROM repository_table")
    suspend fun deleteRepositories()

    @Query("SELECT * FROM repository_table")
    suspend fun getUserRepositories() : List<RepositoriesEntity>
}