package com.codes.githubapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codes.githubapp.domain.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase): ViewModel() {
    fun searchUserByName(username: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}