package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.RepositoriesDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.repository.UserRepoRepository
import kotlinx.coroutines.flow.Flow

class UserRepoRepositoryImpl(private val githubApi: GithubApi, private val repositoriesDao: RepositoriesDao): UserRepoRepository {
    override suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>> {
        TODO("Not yet implemented")
    }
}