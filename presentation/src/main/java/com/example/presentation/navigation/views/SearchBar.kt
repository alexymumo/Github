package com.codes.githubapp.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit, onSearchClicked: (String) -> Unit, placeholder: String) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp).height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = text,
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    onTextChange(it)
                },
                placeholder = {
                    Text(text = placeholder)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(
                        focusRequester = focusRequester
                    ),
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onDone = {
                         focusManager.clearFocus()
                    },
                    onSearch = {
                        onSearchClicked(text)
                    }
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            TODO()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "close_icon"
                        )
                    }
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "trailing_icon"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                )
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    //SearchBar()
}