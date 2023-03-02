package com.codes.repository.repository

import com.codes.cache.dao.FollowersDao
import com.codes.common.Resource
import com.codes.repository.mappers.toDomain
import com.codes.repository.mappers.toEntity
import com.codes.domain.models.Followers
import com.codes.domain.repository.FollowersRepository
import com.codes.remote.api.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FollowersRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val followersDao: FollowersDao):
    FollowersRepository {
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