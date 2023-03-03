package com.codes.cache.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.codes.cache.database.GithubDatabase
import com.codes.cache.sample.repositoriesEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class RepositoriesDaoTest {

    private lateinit var database: GithubDatabase
    private lateinit var repositoriesDao: RepositoriesDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            GithubDatabase::class.java
        ).build()
        repositoriesDao = database.repositoriesDao()
    }

    @Test
    fun `test save repositories`() {
        runBlocking {
            val reposList = listOf(repositoriesEntity)
            repositoriesDao.insertRepositories(reposList)
            val repos = repositoriesDao.getUserRepositories()
            Assert.assertEquals(repos, reposList)
        }
    }

    @Test
    fun `test get user repositories`() {
        runBlocking {
            val repos = listOf(repositoriesEntity)
            repositoriesDao.insertRepositories(repos)
            val result = repositoriesDao.getUserRepositories()
            Truth.assertThat(result).isNotEmpty()
        }

    }
    @Test
    fun `test delete repositories`() {
        runBlocking {
            repositoriesDao.insertRepositories(listOf(repositoriesEntity))
            repositoriesDao.deleteRepositories()
            val repos = repositoriesDao.getUserRepositories()
            Truth.assertThat(repos).isEmpty()
        }
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        database.close()
    }
}