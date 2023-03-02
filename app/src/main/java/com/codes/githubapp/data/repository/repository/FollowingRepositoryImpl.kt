package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.FollowingDao
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.mappers.toDomain
import com.codes.githubapp.data.repository.mappers.toEntity
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.repository.FollowingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FollowingRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val followingDao: FollowingDao): FollowingRepository {
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