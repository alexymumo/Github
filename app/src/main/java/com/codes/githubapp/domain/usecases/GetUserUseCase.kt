package com.codes.githubapp.domain.usecases

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.User
import com.codes.githubapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<User>> {
        return userRepository.getUserByName(username)
    }
}