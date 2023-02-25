package com.codes.githubapp.data.remote.api

import com.codes.githubapp.data.remote.dto.FollowersDto
import com.codes.githubapp.data.remote.dto.UserDto
import com.codes.githubapp.data.remote.dto.RepositoriesDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = "we"
    ): UserDto

    @GET("users/{username}/following")
    suspend fun getUserFollowers(
        @Header("Authorization") accessToken: String = "Token",
        @Path("username") username: String
    ): List<FollowersDto>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = "Token_here"
    ): List<RepositoriesDto>
}