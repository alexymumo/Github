package com.codes.githubapp.data.repository.repository

import com.codes.githubapp.common.Resource
import com.codes.githubapp.data.cache.dao.UserDao
import com.codes.githubapp.data.cache.database.GithubDatabase
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.mappers.toDomain
import com.codes.githubapp.data.repository.mappers.toEntity
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.models.Following
import com.codes.githubapp.domain.models.Repositories
import com.codes.githubapp.domain.models.User
import com.codes.githubapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val githubApi: GithubApi,private val userDao: UserDao): UserRepository {
    /*
    * for searching users
    * @params username
    * */
    override suspend fun getUserByName(username: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())

        val getDataFromDb = userDao.getUserByName(username)
        emit(Resource.Success(getDataFromDb.toDomain()))
        try {
            val userResponse = githubApi.searchUser(username?:"")
            userDao.deleteUser()
            userDao.saveUser(userResponse.toEntity())
            userResponse.let {
                userDao.saveUser(it.toEntity())
            }
        } catch (exception: IOException) {
            emit(Resource.Error(message = "An error occurred"))
        } catch (httpException: HttpException) {
            emit(Resource.Error(message = "An error occurred"))
        }
        val user = userDao.getUserByName(username).toDomain()
        if (user != null) {
            emit(Resource.Success(user))
        }
    }
}