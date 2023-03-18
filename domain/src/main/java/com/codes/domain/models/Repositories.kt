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
    val owner: Owner
)