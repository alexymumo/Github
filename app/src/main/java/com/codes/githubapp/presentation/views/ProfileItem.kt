package com.codes.githubapp.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.domain.models.User
import com.codes.githubapp.R

@Composable
fun ProfileItem(
    user: User?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageItem(
            user = user,
            contentDescription = "image"
        )
        StatItem(
            user = user
        )
    }
}


@Composable
fun ImageItem(
    user: User?,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(user?.avatar_url)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier
            .padding(3.dp)
            .size(100.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Gray, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun StatItem(
    user: User?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = user?.public_repos.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                text = "Repos",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = user?.followers.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
            Text(
                text = "Followers",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = user?.following.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
            Text(
                text = "Following",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
            )
        }
    }
}


@Composable
fun NameItem(
    user: User?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = user?.name.toString(),
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "@${user?.login}",
                maxLines = 1,
                style = TextStyle(
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Composable
fun InfoItem(
    user: User,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.twitter), contentDescription = "twitter")
                 user.twitter_username?.let { Text(text = it) }
        }
        Row {
            Image(painter = painterResource(id = R.drawable.org), contentDescription = "org")
            user.company?.let { Text(text = it) }
        }
        Row {
            Image(painter = painterResource(id = R.drawable.link), contentDescription = "link")
            user.blog?.let { Text(text = it) }
        }
        
        Row {
            Image(painter = painterResource(id = R.drawable.location), contentDescription = "location")
            user.location?.let { Text(text = it) }
        }
    }
}

@Preview
@Composable
fun ProfileItemPreview() {
   //InfoItem()
}



