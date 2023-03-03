package com.codes.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.codes.cache.database.GithubDatabase
import com.codes.cache.sample.followersEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class FollowersDaoTest {

    private lateinit var followersDao: FollowersDao
    private lateinit var database: GithubDatabase

    @Before
    fun setup(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            GithubDatabase::class.java
        ).build()
        followersDao = database.followersDao()
    }

    @Test
    fun `test save user followers`() {
        runBlocking {
            val followerList = listOf(followersEntity)
            followersDao.insertFollowers(followerList)
            val followers = followersDao.getFollowers()
            Truth.assertThat(followers).isEqualTo(followerList)
        }
    }

    @Test
    fun `test delete user followers`() {
        runBlocking {
            followersDao.insertFollowers(listOf(followersEntity))
            followersDao.deleteFollowers()
            val followers = followersDao.getFollowers()
            Truth.assertThat(followers).isEmpty()
        }
    }

    @Test
    fun `test followingDao fetches user followers`() {
        runBlocking {
            followersDao.insertFollowers(listOf(followersEntity))
            val result = followersDao.getFollowers()
            Truth.assertThat(result).isNotEmpty()
        }
    }


    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }
}