package com.codes.githubapp.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.domain.models.Repositories
import com.codes.githubapp.R


@Composable
fun RepoItem(
    repo: Repositories
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 5.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(repo.owner.avatar_url)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentDescription = "repo"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column {
                    Text(
                        text = repo.name,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    repo.description?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Thin
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {

                        repo.language?.let {
                            Text(
                                text = it,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = null
                        )
                        Text(
                            text = repo.forks_count.toString(),
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "image"
                        )
                        Text(
                            text = repo.stargazers_count.toString(),
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RepoItemPreview() {
}