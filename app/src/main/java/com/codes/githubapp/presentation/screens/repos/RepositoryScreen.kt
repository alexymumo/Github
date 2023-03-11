package com.codes.githubapp.presentation.screens.repos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codes.githubapp.presentation.views.RepoItem

@Composable
fun RepositoryScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn{
            items(10) {repo ->

            }
        }
    }
}

@Preview
@Composable
fun RepositoryScreenPreview() {

}