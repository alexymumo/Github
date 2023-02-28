package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.RepositoriesDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.repository.UserRepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UserRepoRepositoryImpl(private val githubApi: GithubApi, private val repositoriesDao: RepositoriesDao): UserRepoRepository {
    override suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>> = flow {
        try {
            emit(Resource.Loading())
            val repositories = repositoriesDao.getUserRepositories()
            emit(Resource.Success(data = null))
        } catch (exception: IOException) {
            emit(Resource.Error(message = "Could not load data"))
        } catch (exception: HttpException) {
            emit(Resource.Error(message = "Could not connect to internet"))
        }
    }
}