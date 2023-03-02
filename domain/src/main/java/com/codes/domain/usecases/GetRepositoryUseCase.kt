package com.codes.domain.usecases

import com.codes.common.Resource
import com.codes.domain.models.Repositories
import com.codes.domain.repository.UserRepoRepository
import kotlinx.coroutines.flow.Flow

class GetRepositoryUseCase(private val userRepoRepository: UserRepoRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Repositories>>> {
        return userRepoRepository.getRepositoryByName(username)
    }
}