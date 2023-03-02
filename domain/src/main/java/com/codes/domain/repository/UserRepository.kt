package com.codes.domain.repository

import com.codes.common.Resource
import com.codes.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserByName(username: String): Flow<Resource<User>>
}