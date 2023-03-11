package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codes.githubapp.presentation.navigation.NavItem
import com.example.presentation.screens.home.HomeScreen
import com.codes.githubapp.presentation.screens.settings.SettingScreen
import com.codes.githubapp.presentation.screens.splash.SplashScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavItem.Home.route) {
        composable(NavItem.Home.route) {
            HomeScreen()
        }
        composable(NavItem.Bookmark.route) {
            SplashScreen()
        }
        composable(NavItem.Settings.route) {
            SettingScreen()
        }
    }
}