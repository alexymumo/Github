package com.codes.githubapp.domain.usecases

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.User
import com.codes.githubapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<User>> {
        return userRepository.getUserByName(username)
    }
}


data class UserUseCase(
    val userUseCase: GetUserUseCase,
    val followersUseCase: GetFollowersUseCase,
    val followingUseCase: GetFollowingUseCase,
    val repositoryUseCase: GetRepositoryUseCase
)