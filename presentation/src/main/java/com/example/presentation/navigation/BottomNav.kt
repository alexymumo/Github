package com.example.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codes.githubapp.presentation.navigation.NavItem

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        NavItem.Home,
        NavItem.Bookmark,
        NavItem.Settings
    )

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { navItem ->
            BottomNavigationItem(
                icon = {
                    Icon(painterResource(id = navItem.icon), contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title, fontSize = 9.sp)
                },
                selected = currentRoute == navItem.route,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(navItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState
                    }
                }
            )
        }
    }
}