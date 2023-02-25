package com.codes.githubapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.codes.githubapp.data.cache.entity.RepositoriesEntity

@Dao
interface RepositoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositoriesEntity: RepositoriesEntity)
}