package com.codes.githubapp.domain.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserByName(username: String): Flow<Resource<User>>
}