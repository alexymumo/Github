package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.cache.entity.BookmarkEntity
import com.codes.githubapp.R

@Composable
fun BookMarkItem(
    bookmarkEntity: BookmarkEntity
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
                        .data(bookmarkEntity.avatar_url)
                        .crossfade(true)
                        .placeholder(R.drawable.github)
                        .build(),
                    contentDescription = "bookmark_image"
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = bookmarkEntity.name!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = bookmarkEntity.login!!,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Followers ${bookmarkEntity.followers}",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Following ${bookmarkEntity.following}",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Repos ${(bookmarkEntity.public_repos)}",
                        fontWeight = FontWeight.Thin,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    //Item()
}