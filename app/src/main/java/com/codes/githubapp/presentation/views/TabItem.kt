package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.presentation.screens.home.HomeViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

sealed class TabItem(val title: String) {
    object FollowerItem: TabItem("Followers")
    object FollowingItem: TabItem("Following")
    object RepositoryItem: TabItem("Repository")
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailItem(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val tabs = listOf(TabItem.FollowerItem, TabItem.FollowingItem, TabItem.RepositoryItem)
    val pageState = rememberPagerState()
    Tabs(tabs = tabs, pageState = pageState)
    DetailScreens(tabs = tabs, pageState = pageState, homeViewModel = homeViewModel)
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailScreens(
    tabs: List<TabItem>,
    pageState: PagerState,
    homeViewModel: HomeViewModel
) {
    val followingState by homeViewModel.following
    val followersState by homeViewModel.followers
    val repositoryState by homeViewModel.repositories
    // add repository state
    HorizontalPager(state = pageState,count = tabs.size) { count ->
        Column(modifier = Modifier.fillMaxSize()) {
            if (count == 0) {
                LazyColumn {
                    items(followersState.followers.size) { followers ->
                        followersState.followers.get(followers)?.let {
                            FollowersItem(it)
                        }
                    }
                }
            }
            if (count == 1) {
                LazyColumn {
                    items(followingState.following.size) { following ->
                        followingState.following.get(following)?.let { following ->
                            FollowingItem(following)
                        }
                    }
                }
            }
            if (count == 2) {
                LazyColumn {
                    items(repositoryState.repositories.size) { repository ->
                        repositoryState.repositories.get(repository)?.let {
                            RepoItem(it)
                        }
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs: List<TabItem>,
    pageState: PagerState
) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pageState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pageState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                text = {
                    Text(
                        text = tabItem.title,
                        maxLines = 1,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Thin
                    )},
                selected = pageState.currentPage == index,
                onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabPreview() {
    val tabs = listOf(
        TabItem.FollowerItem,
        TabItem.FollowingItem,
        TabItem.RepositoryItem
    )
    val pagerState = rememberPagerState()
    Tabs(tabs = tabs, pageState = pagerState)
}