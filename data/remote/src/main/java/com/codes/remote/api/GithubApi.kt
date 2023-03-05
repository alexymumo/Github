package com.codes.remote.api

import com.codes.common.Constants.USER_TOKEN
import com.codes.remote.dto.FollowersDto
import com.codes.remote.dto.FollowingDto
import com.codes.remote.dto.RepositoriesDto
import com.codes.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = USER_TOKEN
    ): UserDto


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = USER_TOKEN
    ): List<FollowersDto>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = USER_TOKEN
     ): List<FollowingDto>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = USER_TOKEN
    ): List<RepositoriesDto>
}