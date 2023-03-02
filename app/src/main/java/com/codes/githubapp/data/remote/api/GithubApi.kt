package com.codes.githubapp.data.remote.api

import com.codes.githubapp.BuildConfig
import com.codes.githubapp.data.remote.dto.FollowersDto
import com.codes.githubapp.data.remote.dto.FollowingDto
import com.codes.githubapp.data.remote.dto.RepositoriesDto
import com.codes.githubapp.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = BuildConfig.API_KEY
    ): UserDto //"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"


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = BuildConfig.API_KEY
    ): List<FollowersDto>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = BuildConfig.API_KEY
     ): List<FollowingDto>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = BuildConfig.API_KEY
    ): List<RepositoriesDto>
}