package com.codes.domain.usecases

import com.codes.common.Resource
import com.codes.domain.models.Following
import com.codes.domain.repository.FollowingRepository
import kotlinx.coroutines.flow.Flow

class GetFollowingUseCase(private val followingRepository: FollowingRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Following>>> {
        return followingRepository.getFollowingByName(username)
    }
}