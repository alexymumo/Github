package com.codes.githubapp.data.remote.api

import com.codes.githubapp.data.remote.dto.FollowersDto
import com.codes.githubapp.data.remote.dto.OwnerDto
import com.codes.githubapp.data.remote.dto.RepositoriesDto
import com.codes.githubapp.domain.models.Followers
import com.codes.githubapp.domain.models.Owner
import com.codes.githubapp.domain.models.Repositories
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Header("Authorization") accessToken: String = "we",
        @Path("username") username: String
    ): OwnerDto

    @GET("users/{username}/following")
    suspend fun getUserFollowers(
        @Header("Authorization") accessToken: String = "Token",
        @Path("username") username: String
    ): FollowersDto

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String = "Token_here"
    ): RepositoriesDto
}