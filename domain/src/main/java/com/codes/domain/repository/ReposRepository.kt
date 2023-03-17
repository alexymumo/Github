package com.codes.domain.repository

import com.codes.common.Resource
import com.codes.domain.models.Repositories
import kotlinx.coroutines.flow.Flow

interface ReposRepository {
    suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>>
}