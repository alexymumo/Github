package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
                    // Implement horizontal pager
                }
            }
        }
    )
}




/*
* {
        LazyColumn {
            item {
                if (userState.user != null && !userState.isLoading) {
                    ProfileItem(
                        user = userState.user
                    )
                    NameItem(
                        user = userState.user
                    )
                    Divider(modifier = Modifier.fillMaxWidth())
                    InfoItem(user = userState.user!!)
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BioItem(
                            user = userState.user
                        )
                    }
                }

                if (userState.user == null || userState.isLoading) {
                    EmptyItem(
                        text = "Username does not exit",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
                if(userState.isLoading) {
                    CircularProgressIndicator()
                }
            }
            item {
                Text(
                    text = "Following",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    items(followingState.following) { following ->
                        FollowingItem(following = following)
                    }
                }
            }
            item {
                Text(
                    text = "Followers",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    items(followersState.followers) { followers ->
                        FollowersItem(followers = followers)
                    }
                }
            }
        }
    }
* */