package com.codes.githubapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.R
import com.codes.githubapp.presentation.views.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val userState by homeViewModel.user
    val followingState by homeViewModel.following
    val followersState by homeViewModel.followers
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
        }
    ) {
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
}


@Composable
fun EmptyScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.github),
            contentDescription = "null"
        )
    }
}

@Preview
@Composable
fun EmptyScreenPreview() {
    EmptyScreen()
}