package com.example.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.BottomNav
import com.example.presentation.navigation.NavigationGraph

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