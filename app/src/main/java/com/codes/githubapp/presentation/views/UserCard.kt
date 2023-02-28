package com.codes.githubapp.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.githubapp.domain.models.User

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    user: User?
) {
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        elevation = 20.dp
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
                        .clip(RoundedCornerShape(8.dp))
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = user?.name?: "NA",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = user?.login?: "NA",
                        fontWeight = FontWeight.Thin,
                        fontSize = 10.sp
                    )

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Bio",
                )
                Text(
                    text = user?.bio?: "NA",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Repositories",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = user?.public_repos.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Followers",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = user?.followers.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Following",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = user?.following.toString()?: "0",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun UserItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        elevation = 20.dp
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = com.codes.githubapp.R.drawable.github),
                    contentDescription = "image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "Alex Mumo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "alexymumo",
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun UserItemPreview() {
    UserItem()
}

