package com.codes.domain.usecases

import com.codes.common.Resource
import com.codes.domain.models.Repositories
import com.codes.domain.repository.ReposRepository
import kotlinx.coroutines.flow.Flow

class GetRepositoryUseCase(private val repository: ReposRepository) {
    suspend operator fun invoke(username: String): Flow<Resource<List<Repositories>>> {
        return repository.getRepositoryByName(username)
    }
}