package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.FollowingDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.repository.FollowingRepository
import kotlinx.coroutines.flow.Flow

class FollowingRepositoryImpl(private val githubApi: GithubApi, private val followingDao: FollowingDao): FollowingRepository {
    override suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>> {
        TODO("Not yet implemented")
    }
}