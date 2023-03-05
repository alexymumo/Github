package com.codes.domain.usecases

import com.codes.common.Resource
import com.codes.domain.models.User
import com.codes.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<User>> {
        return userRepository.getUserByName(username)
    }
}


data class UserUseCase(
    val userUseCase: GetUserUseCase,
    val followersUseCase: GetFollowersUseCase,
    val followingUseCase: GetFollowingUseCase
    //val repositoryUseCase: GetRepositoryUseCase
)