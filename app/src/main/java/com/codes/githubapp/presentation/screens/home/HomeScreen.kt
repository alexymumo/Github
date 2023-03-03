package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
                placeholder = "Search..."
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
            }
            item {

            }
        }
    }
}