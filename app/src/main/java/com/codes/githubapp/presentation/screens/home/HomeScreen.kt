package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.presentation.views.SearchBar
import com.codes.githubapp.presentation.views.UserCard


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
   // val state = homeViewModel.userData.value
    val search = homeViewModel.search

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
                })
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (userState.user != null && !userState.isLoading) {
                UserCard(
                    user = userState.user,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}