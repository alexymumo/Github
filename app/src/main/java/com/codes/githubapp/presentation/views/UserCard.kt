package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.githubapp.domain.models.User

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    user: User?
) {
    Column {
        Row(
            modifier.fillMaxWidth()
        ) {
            Card(
                modifier
                    .fillMaxWidth()
                    .height(100.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 10.dp
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(user?.avatar_url)
                                .crossfade(true)
                                .build(),
                            contentDescription = "image",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(80.dp)
                        )
                        //Text(text = user?.name?: user?.login ?: "Null")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UserItemPreview() {
    //UserItem()
}



/*
*
*    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Alex Mumo",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }*/