package com.codes.githubapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codes.githubapp.presentation.screens.bookmark.BookMarkScreen
import com.codes.githubapp.presentation.screens.home.HomeScreen
import com.codes.githubapp.presentation.screens.settings.SettingScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavItem.Home.route) {
        composable(NavItem.Home.route) {
            HomeScreen()
        }
        composable(NavItem.Bookmark.route) {
            BookMarkScreen(navController = navController)
        }
        composable(NavItem.Settings.route) {
            SettingScreen(navController = navController)
        }
    }
}