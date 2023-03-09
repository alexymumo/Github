package com.example.presentation.navigation.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.domain.models.Followers


@Composable
fun FollowersItem(
    modifier: Modifier = Modifier,
    followers: Followers
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(followers.avatar_url)
                .crossfade(true)
                .build(),
            contentDescription = "image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = Color.Gray)
        )
        Text(
            text = followers.login,
            style = TextStyle(
                color = MaterialTheme.colors.background,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
    }
}