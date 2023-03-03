package com.codes.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codes.cache.dao.FollowersDao
import com.codes.cache.dao.FollowingDao
import com.codes.cache.dao.RepositoriesDao
import com.codes.cache.dao.UserDao
import com.codes.cache.entity.FollowersEntity
import com.codes.cache.entity.FollowingEntity
import com.codes.cache.entity.RepositoriesEntity
import com.codes.cache.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        RepositoriesEntity::class,
        FollowingEntity::class,
        FollowersEntity::class],
    exportSchema = false,
    version = 5
)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun followersDao(): FollowersDao
    abstract fun userDao(): UserDao
    abstract fun repositoriesDao(): RepositoriesDao
    abstract fun followingDao(): FollowingDao
}