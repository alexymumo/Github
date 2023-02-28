package com.codes.githubapp.domain.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Repositories
import kotlinx.coroutines.flow.Flow

interface UserRepoRepository {
    suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>>
}