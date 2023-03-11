package com.codes.remote.api

import com.codes.remote.dto.FollowersDto
import com.codes.remote.dto.FollowingDto
import com.codes.remote.dto.RepositoriesDto
import com.codes.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Path("username") username: String
    ): UserDto


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String
    ): List<FollowersDto>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String
     ): List<FollowingDto>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String
    ): List<RepositoriesDto>
}