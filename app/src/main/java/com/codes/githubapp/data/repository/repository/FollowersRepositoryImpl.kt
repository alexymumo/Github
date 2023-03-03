package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.FollowersDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.mappers.toDomain
import com.codes.githubapp.data.repository.mappers.toEntity
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.repository.FollowersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FollowersRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val followersDao: FollowersDao): FollowersRepository {
    override suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>> = flow {
        emit(Resource.Loading())
        val getFollowersFromDb = followersDao.getFollowers().map { it.toDomain() }
        emit(Resource.Success(getFollowersFromDb))
        try {
            val followersResponse = githubApi.getUserFollowers(username)
            followersDao.deleteFollowers()
            followersDao.insertFollowers(followersResponse.map { it.toEntity() })
        } catch (e: IOException) {
            emit(Resource.Error(message = "An error occurred"))

        } catch (e: HttpException) {
            emit(Resource.Error(message = "An error occurred"))
        }
        val result = followersDao.getFollowers().map { it.toDomain() }
        emit(Resource.Success(result))
    }
}