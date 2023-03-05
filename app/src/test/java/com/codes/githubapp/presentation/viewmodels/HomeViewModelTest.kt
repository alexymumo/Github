package com.codes.githubapp.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codes.domain.usecases.UserUseCase
import com.codes.githubapp.presentation.screens.home.HomeViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel
    private val userUseCase: UserUseCase = mock()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(userUseCase)
    }

    @Test
    fun `test to fetch user`() {
        runBlocking {
            val username = "Alex"
            homeViewModel.searchUserByName(username)
            verify(homeViewModel)
        }
    }
}