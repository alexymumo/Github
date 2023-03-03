package com.codes.githubapp.presentation.screens.repos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.usecases.UserUseCase
import com.codes.githubapp.presentation.state.RepositoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(private val userUseCase: UserUseCase): ViewModel() {
    private val _repository = mutableStateOf(RepositoryState())
    val repository: State<RepositoryState> = _repository

    fun getRepository(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _repository.value = _repository.value.copy(
                isLoading = true
            )
            userUseCase.repositoryUseCase(username).collectLatest { repositories ->
                when(repositories) {
                    is Resource.Success -> {
                        _repository.value = _repository.value.copy(
                            repositories = repositories.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _repository.value = _repository.value.copy(
                            error = "An error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _repository.value = _repository.value.copy(
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}