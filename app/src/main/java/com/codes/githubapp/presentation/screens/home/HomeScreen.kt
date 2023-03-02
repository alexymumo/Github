package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.presentation.views.EmptyScreen
import com.codes.githubapp.presentation.views.SearchBar
import com.codes.githubapp.presentation.views.UserCard


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val userState by homeViewModel.userData
    val searchString by homeViewModel.search
    
    Scaffold(
        topBar = {
            SearchBar(
                text = searchString,
                onTextChange = {
                    homeViewModel.setSearch(it) },
                onSearchClicked = {
                    homeViewModel.searchUserByName(it.trim())
                },
                placeholder = "Search here..."
            )
        }
    ) {
        LazyColumn {
            item {
                if (userState.user != null && !userState.isLoading) {
                    UserCard(
                        user = userState.user
                    )
                }
                if (userState.user == null) {
                    EmptyScreen()
                }
            }
            item {

            }
        }
    }
}