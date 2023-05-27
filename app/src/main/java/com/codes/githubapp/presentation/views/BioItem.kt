package com.codes.githubapp.presentation.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codes.domain.models.User

@Composable
fun BioItem(
    user: User?
) {
    Card(
        border = BorderStroke(width = 0.5.dp, Color.Gray),
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .wrapContentHeight()
            .testTag("bio item"),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = user?.bio.toString(),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun BioItemPreview() {
    //BioItem(bio = "Alex Mumo")
}