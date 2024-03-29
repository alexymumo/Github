package com.codes.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    val avatar_url: String
)

@Serializable
data class Repositories(
    val description: String?,
    val id: Int,
    val name: String,
    val owner: Owner,
    val language: String?,
    val created_at: String,
    val watchers_count: Int,
    val forks_count: Int,
    val stargazers_count: Int
)