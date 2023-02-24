package com.codes.githubapp.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codes.githubapp.data.cache.dao.FollowersDao
import com.codes.githubapp.data.cache.dao.RepositoriesDao
import com.codes.githubapp.data.cache.dao.UserDao
import com.codes.githubapp.data.cache.entity.FollowersEntity
import com.codes.githubapp.data.cache.entity.UserEntity
import com.codes.githubapp.data.cache.entity.RepositoriesEntity

@Database(
    entities = [
        UserEntity::class,
        RepositoriesEntity::class,
        FollowersEntity::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun followersDao(): FollowersDao
    abstract fun userDao(): UserDao
    abstract fun repositoriesDao(): RepositoriesDao
}