package com.codes.domain.repository

import com.codes.common.Resource
import com.codes.domain.models.Following
import kotlinx.coroutines.flow.Flow

interface FollowingRepository {
    suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>>
}