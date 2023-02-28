package com.codes.githubapp.presentation.state

import com.codes.githubapp.domain.models.User

data class UserState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: User? = null
)
