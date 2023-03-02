package com.codes.githubapp.presentation.state

import com.codes.domain.models.Following


data class FollowingState(
    val following: List<Following> = emptyList(),
    val errors: String? = null,
    val isLoading: Boolean = false
)
