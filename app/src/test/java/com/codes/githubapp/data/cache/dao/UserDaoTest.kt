package com.codes.githubapp.data.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.codes.githubapp.data.cache.database.GithubDatabase
import com.codes.githubapp.data.cache.entity.UserEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class UserDaoTest {
    private lateinit var userDao: UserDao
    private lateinit var database: GithubDatabase

    @Before
    @Throws(IOException::class)
    fun setup() { 
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            GithubDatabase::class.java
        ).build()
        userDao = database.userDao()
    }

    val userEntity = UserEntity(
        avatar_url = "my url",
        bio = "1",
        blog = "my blog",
        collaborators = 1,
        company = "github",
        created_at = "12pm",
        disk_usage = 1,
        email = "git.com",
        events_url = "1",
        followers = 12,
        followers_url = "ale",
        following = 23,
        following_url = "23",
        gists_url = "1",
        gravatar_id = "1",
        hireable = false,
        html_url = "1",
        id = 1,
        location = "1",
        login = "Alex Mumo",
        name = "Alex Mumo",
        node_id = "1",
        organizations_url = "1",
        owned_private_repos = 1,
        private_gists = 12,
        public_gists = 23,
        public_repos = 23,
        received_events_url = "1",
        repos_url = "1",
        site_admin = false,
        starred_url = "1",
        subscriptions_url = "1",
        total_private_repos = 45,
        twitter_username = "1",
        two_factor_authentication = false,
        type = "1",
        updated_at = "1",
        url = "1"
    )


    @Test
    fun `test insert user`() {
        runBlocking {
            userDao.saveUser(userEntity)
            val result = userDao.getUserByName("Alex Mumo")
            Truth.assertThat(result).isEqualTo(userEntity)
        }
    }

    @Test
    fun `test delete user`() {
        runBlocking {
            userDao.saveUser(userEntity)
            userDao.deleteUser()
            val result = userDao.getUserByName("Alex Mumo")
            Truth.assertThat(result).isNull()
        }
    }

    @Test
    fun `test getUserByName`() {
        runBlocking {
            userDao.saveUser(userEntity)
            val user = userDao.getUserByName("Alex Mumo")
            Truth.assertThat(user).isNotNull()
        }
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }
}