package com.codes.githubapp.domain.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserByName(username: String): Flow<Resource<User>>
    suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>>
    suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>>
    suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>>
}