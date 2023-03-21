package com.codes.githubapp.presentation.screens.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codes.githubapp.presentation.views.BookMarkItem

@Composable
fun BookMarkScreen(
    bookMarkViewModel: BookMarkViewModel = hiltViewModel(),
    navController: NavController
) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back")
                }
                Text(
                    text = "BookMarks",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    ) { paddingValues ->
        val bookMarks = bookMarkViewModel.bookMarks.collectAsState(emptyList())
        LazyColumn(contentPadding = paddingValues) {
            items(bookMarks.value) { bookmarkEntity ->
                BookMarkItem(bookmarkEntity = bookmarkEntity)
            }
        }
    }
}