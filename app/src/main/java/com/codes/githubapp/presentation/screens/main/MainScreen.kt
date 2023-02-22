package com.codes.githubapp.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codes.githubapp.presentation.navigation.BottomNav
import com.codes.githubapp.presentation.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
        },
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) {
        NavigationGraph(navHostController = navController)
    }
}