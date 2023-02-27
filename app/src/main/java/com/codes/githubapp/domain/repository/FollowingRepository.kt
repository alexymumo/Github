package com.codes.githubapp.domain.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Following
import kotlinx.coroutines.flow.Flow

interface FollowingRepository {
    suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>>
}