package com.codes.domain.usecases

import com.codes.common.Resource
import com.codes.domain.models.Followers
import com.codes.domain.repository.FollowersRepository
import kotlinx.coroutines.flow.Flow

class GetFollowersUseCase(private val followersRepository: FollowersRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Followers>>> {
        return followersRepository.getFollowersByName(username)

    }
}