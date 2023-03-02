package com.codes.remote.api

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
        @Header("Authorization") accessToken: String = "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"
    ): UserDto


    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String =""// BuildConfig.API_KEY
    ): List<FollowersDto>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String =""// BuildConfig.API_KEY
     ): List<FollowingDto>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = ""//BuildConfig.API_KEY
    ): List<RepositoriesDto>
}