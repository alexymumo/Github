package com.codes.domain.repository

import com.codes.common.Resource
import com.codes.domain.models.Followers
import kotlinx.coroutines.flow.Flow

interface FollowersRepository {
    suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>>
}