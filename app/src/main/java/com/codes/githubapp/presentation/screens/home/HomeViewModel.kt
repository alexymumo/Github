package com.codes.githubapp.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.usecases.UserUseCase
import com.codes.githubapp.presentation.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userUseCase: UserUseCase): ViewModel() {

    private val _userData = mutableStateOf(UserState())
    val userData: State<UserState> = _userData

    private val _search = mutableStateOf("")
    val search: State<String> = _search

    fun setSearch(value: String) {
        _search.value = value
    }

    fun searchUserByName(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (username.isEmpty()) {
                TODO()
            }
            _userData.value = userData.value.copy(
                isLoading = false
            )

            userUseCase.userUseCase(username).collectLatest { user ->
                when(user) {
                    is Resource.Loading -> {
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Success -> {
                        _userData.value = userData.value.copy(
                            isLoading = false,
                            user = user.data
                        )
                        //followers, repositories
                    }
                }
            }
        }
    }

    fun getUserFollowers(username: String) {

    }

    fun getUserRepositories(username: String) {

    }
}