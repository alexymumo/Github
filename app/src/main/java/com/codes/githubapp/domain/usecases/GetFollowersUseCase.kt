package com.codes.githubapp.domain.usecases

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.repository.FollowersRepository
import kotlinx.coroutines.flow.Flow

class GetFollowersUseCase(private val followersRepository: FollowersRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Followers>>> {
        return followersRepository.getFollowersByName(username)

    }
}