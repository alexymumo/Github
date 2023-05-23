package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.presentation.screens.bookmark.BookMarkViewModel
import com.codes.githubapp.presentation.views.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    bookMarkViewModel: BookMarkViewModel = hiltViewModel()
) {
    val userState by homeViewModel.user
    val searchString by homeViewModel.search
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    
    Scaffold(
        scaffoldState = scaffoldState,
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
        },
        content = { paddingValues ->
            Column(modifier = Modifier.fillMaxSize()) {
                if (userState.user != null && !userState.isLoading) {
                    ProfileItem(
                        user = userState.user!!
                    )
                    NameItem(
                        user = userState.user!!,
                        bookMarkViewModel = bookMarkViewModel
                    )
                    Divider(modifier = Modifier.fillMaxWidth())
                    InfoItem(
                        user = userState.user!!
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        BioItem(
                            user = userState.user
                        )
                    }
                    DetailItem(homeViewModel = homeViewModel)
                    
                    Button(
                        onClick = {},
                        modifier = Modifier.testTag("first button")
                    ) {
                        Text(text = "Push clicked")
                    }
                    // Implement horizontal pager
                }
            }
        }
    )
}

