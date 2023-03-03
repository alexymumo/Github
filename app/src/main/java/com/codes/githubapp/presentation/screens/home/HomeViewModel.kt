package com.codes.githubapp.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codes.githubapp.common.Resource
import com.codes.githubapp.domain.usecases.UserUseCase
import com.codes.githubapp.presentation.state.FollowerState
import com.codes.githubapp.presentation.state.FollowingState
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

    private val _following = mutableStateOf(FollowingState())
    val following: State<FollowingState> = _following

    private val _followers = mutableStateOf(FollowerState())
    val followers: State<FollowerState> = _followers

    private val _search = mutableStateOf("")
    val search: State<String> = _search

    fun setSearch(value: String) {
        _search.value = value
    }

    fun searchUserByName(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
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
                    }
                }
            }
        }
    }

    fun getUserFollowers(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _followers.value = _followers.value.copy(
                isLoading = false
            )

            userUseCase.followersUseCase(username).collectLatest { followers ->
                when(followers) {
                    is Resource.Loading -> {
                        _followers.value = _followers.value.copy(
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _followers.value = _followers.value.copy(
                            errors = "An error occurred"
                        )
                    }

                    is Resource.Success -> {
                        _followers.value = _followers.value.copy(
                            followers = followers.data?: emptyList(),
                            isLoading = false
                        )

                    }
                }
            }
        }
    }

    fun getUserFollowing(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userUseCase.followingUseCase(username).collectLatest { following ->
                when(following) {
                    is Resource.Success -> {
                        _following.value = _following.value.copy(
                            following = following.data ?: emptyList()
                        )
                    }
                    is Resource.Error -> {
                        _following.value = _following.value.copy(
                            errors = "An error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _following.value = _following.value.copy(
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}