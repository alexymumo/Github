package com.codes.githubapp.presentation.state

import com.codes.githubapp.domain.models.Following

data class FollowingState(
    val followers: List<Following> = emptyList(),
    val errors: String? = null,
    val isLoading: Boolean = false
)
