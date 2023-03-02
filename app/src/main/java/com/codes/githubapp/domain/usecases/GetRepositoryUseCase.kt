package com.codes.githubapp.domain.usecases

import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.repository.UserRepoRepository
import kotlinx.coroutines.flow.Flow

class GetRepositoryUseCase(private val userRepoRepository: UserRepoRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Repositories>>> {
        return userRepoRepository.getRepositoryByName(username)
    }
}