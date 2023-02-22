package com.codes.githubapp.presentation.navigation

import com.codes.githubapp.R

sealed class NavItem (val route: String, val icon: Int, val title: String) {
    object Home: NavItem("home", R.drawable.home, "Home")
    object Bookmark: NavItem("bookmark", R.drawable.bookmark, "Bookmark")
    object Settings: NavItem("settings", R.drawable.settings, "Settings")
}