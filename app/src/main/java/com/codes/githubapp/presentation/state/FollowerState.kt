package com.codes.githubapp.presentation.state

import com.codes.githubapp.domain.models.Followers

data class FollowerState(
    val followers: List<Followers> = emptyList(),
    val errors: String? = null,
    val isLoading: Boolean = false
)
