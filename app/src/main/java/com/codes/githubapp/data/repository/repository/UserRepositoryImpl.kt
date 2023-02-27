package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.UserDao
import com.codes.githubapp.data.cache.database.GithubDatabase
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.mappers.toDomain
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.models.User
import com.codes.githubapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// add dao
class UserRepositoryImpl @Inject constructor(private val githubApi: GithubApi,private val userDao: UserDao): UserRepository {
    /*
    * for searching users
    * @params username
    * */
    override suspend fun getUserByName(username: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val githubResponse = githubApi.searchUser(username)
            if (githubResponse != null) {
                emit(Resource.Success(githubResponse.toDomain()))
            }
        } catch (exception: IOException) {
            emit(Resource.Error(message = "An error occurred"))
        } catch (httpException: HttpException) {
            emit(Resource.Error(message = "An error occurred"))
        }
    }

    override suspend fun getFollowersByName(username: String): Flow<Resource<List<Followers>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRepositoryByName(username: String): Flow<Resource<List<Repositories>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFollowingByName(username: String): Flow<Resource<List<Following>>> {
        TODO("Not yet implemented")
    }
}