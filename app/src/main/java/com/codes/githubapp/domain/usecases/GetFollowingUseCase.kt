package com.codes.githubapp.domain.usecases

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.repository.FollowingRepository
import kotlinx.coroutines.flow.Flow

class GetFollowingUseCase(private val followingRepository: FollowingRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Following>>> {
        return followingRepository.getFollowingByName(username)
    }
}