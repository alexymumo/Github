package com.codes.githubapp.data.cache.dao

import com.codes.githubapp.data.cache.database.GithubDatabase
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

    }

    @Test


    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }
}