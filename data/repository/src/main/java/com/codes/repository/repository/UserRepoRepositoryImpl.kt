package com.codes.repository.repository

import com.codes.cache.dao.RepositoriesDao
import com.codes.common.Resource
import com.codes.domain.models.Repositories
import com.codes.domain.repository.ReposRepository
import com.codes.repository.mappers.toDomain
import com.codes.repository.mappers.toEntity
import com.codes.remote.api.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepoRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val repositoriesDao: RepositoriesDao): ReposRepository {
    override suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>> = flow {
        emit(Resource.Loading())
        val getRepositoriesFromDb = repositoriesDao.getUserRepositories().map { it.toDomain() }
        emit(Resource.Success(getRepositoriesFromDb))
        try {
            val repositoriesResponse = githubApi.getUserRepositories(username).map { it.toEntity() }
            repositoriesDao.deleteRepositories()
            repositoriesDao.insertRepositories(repositoriesResponse)
        } catch (exception: IOException) {
            emit(Resource.Error(message = "Could not load data"))
        } catch (exception: HttpException) {
            emit(Resource.Error(message = "Could not connect to internet"))
        }
        val repos = repositoriesDao.getUserRepositories().map { it.toDomain() }
        emit(Resource.Success(repos))
    }
}