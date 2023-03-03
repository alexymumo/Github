package com.codes.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.codes.cache.database.GithubDatabase
import com.codes.cache.sample.userEntity
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