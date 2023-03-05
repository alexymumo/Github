package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codes.domain.models.User

@Composable
fun UserCard(
    user: User?
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 20.dp
        ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(user?.avatar_url)
                            .crossfade(true)
                            .build(),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(100.dp)
                            .weight(3f)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Column {
                        Text(
                            text = user?.name?: "NA",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = user?.login?: "NA",
                            fontWeight = FontWeight.Thin,
                            fontSize = 15.sp
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Following ${user?.following.toString()}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Followers ${user?.followers.toString()}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    /*
                    BioItem(
                        bio = user?.bio?: "NA"
                    )*/
                }
            }
        }
    }
}


@Composable
fun InfoCard() {

}


@Preview
@Composable
fun UserItemPreview() {

   /* BioItem(
        bio = "Alex Mumo"
    )

    */
}

