package com.codes.githubapp.domain.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Followers
import kotlinx.coroutines.flow.Flow

interface FollowersRepository {
    suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>>
}