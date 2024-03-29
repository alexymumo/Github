package com.codes.githubapp.presentation.state

import com.codes.domain.models.Repositories

data class RepositoryState (
    val repositories: List<Repositories> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = false
)