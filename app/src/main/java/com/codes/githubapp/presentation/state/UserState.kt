package com.codes.githubapp.presentation.state

import com.codes.domain.models.Followers
import com.codes.domain.models.Following
import com.codes.domain.models.Repositories
import com.codes.domain.models.User
data class UserState(
    val following: List<Following> = emptyList(),
    val followers: List<Followers> = emptyList(),
    val repositories: List<Repositories> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: User? = null
)
