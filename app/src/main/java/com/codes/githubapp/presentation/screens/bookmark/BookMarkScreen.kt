package com.codes.githubapp.presentation.screens.bookmark

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.codes.githubapp.presentation.views.BookMarkItem

@Composable
fun BookMarkScreen(
    bookMarkViewModel: BookMarkViewModel = hiltViewModel()
) {
    val bookMarks = bookMarkViewModel.bookMarks.collectAsState(emptyList())
    LazyColumn {
        items(bookMarks.value) { bookmarkEntity ->
            BookMarkItem(bookmarkEntity = bookmarkEntity)
        }
    }
}