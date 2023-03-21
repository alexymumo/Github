package com.codes.githubapp.presentation.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.codes.domain.models.Following

@Composable
fun FollowingItem(
    following: Following,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(following.avatar_url)
                        .crossfade(true)
                        .build(),
                    contentDescription = "bookmark_image"
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = following.login,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "",
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}


