package com.codes.repository.repository

import com.codes.cache.dao.UserDao
import com.codes.common.Resource
import com.codes.repository.mappers.toDomain
import com.codes.repository.mappers.toEntity
import com.codes.domain.models.User
import com.codes.domain.repository.UserRepository
import com.codes.remote.api.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val githubApi: GithubApi, private val userDao: UserDao): UserRepository {
    /*
    * for searching users
    * @params username
    * */
    override suspend fun getUserByName(username: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())

        val getDataFromDb = userDao.getUserByName(username)
        if (getDataFromDb != null) {
            emit(Resource.Success(getDataFromDb.toDomain()))
        }
        try {
            val userResponse = githubApi.searchUser(username)
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