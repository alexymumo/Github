package com.codes.repository.repository

import com.codes.cache.dao.FollowingDao
import com.codes.common.Resource
import com.codes.repository.mappers.toDomain
import com.codes.repository.mappers.toEntity
import com.codes.domain.models.Following
import com.codes.domain.repository.FollowingRepository
import com.codes.remote.api.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FollowingRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val followingDao: FollowingDao):
    FollowingRepository {
    override suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>> = flow {

        emit(Resource.Loading())
        val getFollowingFromDb = followingDao.getFollowing().map { it.toDomain() }
        emit(Resource.Success(getFollowingFromDb))
        try {
            val followingResponse = githubApi.getUserFollowing(username).map { it.toEntity() }
            followingDao.deleteFollowing()
            followingDao.insertFollowing(followingResponse)
        } catch (e: IOException) {
            emit(Resource.Error(message = "An error occurred"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "An error occurred"))
        }
        val result = followingDao.getFollowing().map { it.toDomain() }
        emit(Resource.Success(result))
    }
}