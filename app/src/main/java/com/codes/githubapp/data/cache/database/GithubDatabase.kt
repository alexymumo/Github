package com.codes.githubapp.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codes.githubapp.data.cache.dao.FollowersDao
import com.codes.githubapp.data.cache.dao.FollowingDao
import com.codes.githubapp.data.cache.dao.RepositoriesDao
import com.codes.githubapp.data.cache.dao.UserDao
import com.codes.githubapp.data.cache.entity.FollowersEntity
import com.codes.githubapp.data.cache.entity.FollowingEntity
import com.codes.githubapp.data.cache.entity.UserEntity
import com.codes.githubapp.data.cache.entity.RepositoriesEntity

@Database(
    entities = [
        UserEntity::class,
        RepositoriesEntity::class,
        FollowingEntity::class,
        FollowersEntity::class],
    exportSchema = false,
    version = 2
)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun followersDao(): FollowersDao
    abstract fun userDao(): UserDao
    abstract fun repositoriesDao(): RepositoriesDao
    abstract fun followingDao(): FollowingDao
}