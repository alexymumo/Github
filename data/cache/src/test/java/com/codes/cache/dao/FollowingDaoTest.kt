package com.codes.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.codes.cache.database.GithubDatabase
import com.codes.cache.sample.followingEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class FollowingDaoTest {

    private lateinit var database: GithubDatabase
    private lateinit var followingDao: FollowingDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            GithubDatabase::class.java
        ).build()
        followingDao = database.followingDao()
    }

    @Test
    fun `test save user following`() {
        runBlocking {
            val followingList = listOf(followingEntity)
            followingDao.insertFollowing(followingList)
            val following = followingDao.getFollowing()
            Truth.assertThat(following).isEqualTo(followingList)
        }
    }

    @Test
    fun `test delete user following`() {
        runBlocking {
            followingDao.insertFollowing(listOf(followingEntity))
            followingDao.deleteFollowing()
            val following = followingDao.getFollowing()
            Truth.assertThat(following).isEmpty()
        }
    }

    @Test
    fun `test followingDao fetches user following`() {
        runBlocking {
            followingDao.insertFollowing(listOf(followingEntity))
            val result = followingDao.getFollowing()
            Truth.assertThat(result).isNotEmpty()
        }
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        database.close()
    }
}