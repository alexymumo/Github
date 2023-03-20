package com.codes.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codes.cache.dao.*
import com.codes.cache.entity.*

@Database(
    entities = [
        UserEntity::class,
        RepositoriesEntity::class,
        FollowingEntity::class,
        FollowersEntity::class,
        BookmarkEntity::class],
    exportSchema = false,
    version = 12
)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun followersDao(): FollowersDao
    abstract fun userDao(): UserDao
    abstract fun repositoriesDao(): RepositoriesDao
    abstract fun followingDao(): FollowingDao
    abstract fun bookMarkDao(): BookMarkDao
}