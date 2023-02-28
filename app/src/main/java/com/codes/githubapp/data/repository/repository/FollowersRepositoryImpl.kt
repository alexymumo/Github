package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.FollowersDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.repository.FollowersRepository
import kotlinx.coroutines.flow.Flow

class FollowersRepositoryImpl(private val githubApi: GithubApi, private val followersDao: FollowersDao): FollowersRepository {
    override suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>> {
        TODO("Not yet implemented")
    }
}