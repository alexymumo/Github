package com.codes.githubapp.presentation.navigation

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
import com.codes.domain.usecases.UserUseCase
import com.codes.githubapp.presentation.screens.home.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

sealed class TabItem(val title: String) {
    object FollowerItem: TabItem("Followers")
    object FollowingItem: TabItem("Following")
    object RepositoryItem: TabItem("Repositories")
}

@Composable
fun DetailItem(
    userUseCase: UserUseCase,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val followingState by homeViewModel.following
    val followersState by homeViewModel.followers
    val repositoryState by homeViewModel

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pageState: PagerState) {
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
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
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