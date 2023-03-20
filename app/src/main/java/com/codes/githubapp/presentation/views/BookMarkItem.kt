package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codes.cache.entity.BookmarkEntity

@Composable
fun BookMarkItem(
    bookmarkEntity: BookmarkEntity
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = bookmarkEntity.name!!)
        }
    }
}