package com.example.tinswaterreminderapp.ui.chatlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.tinswaterreminderapp.R
import com.example.tinswaterreminderapp.R.*

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable
fun ChatListContent() {
    SimpleOutlinedTextFieldSample {
        LazyColumn(Modifier.padding(bottom = 93.dp)) {
            for (i in 0..10) {
                item {
                    if (i % 2 == 0) {
                        ChatItemWithHeader()
                    } else {
                        ChatItem()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleOutlinedTextFieldSample(content: @Composable (PaddingValues) -> Unit) {
    var text by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                border = BorderStroke(1.dp, Color.Gray)
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text(stringResource(id = string.hintEnterText)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(dimensionResource(id = dimen.spacing_16))
                )
            }
        }
    ) {
        content.invoke(it)
    }
}

@ExperimentalUnitApi
@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ChatItemWithHeader() {
    Row {
        Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(dimensionResource(id = dimen.avatar_size)),
                painter = rememberImagePainter(
                        data = "https://minnetonkaorchards.com/wp-content/uploads/2021/04/Bright-Red-Apple.jpg",
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null
        )
        Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = dimen.spacing_16)),
                verticalArrangement = spacedBy(dimensionResource(id = dimen.spacing_4))
        ) {
            Row {
                Text(
                        text = "User A",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Bottom)
                )
                Text(
                        text = "8:30pm",
                        fontSize = TextUnit(8.dp.value, TextUnitType.Sp),
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(start = dimensionResource(id = dimen.spacing_4))
                )
            }

            ChatBubble(message = "Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World")
        }
    }
}

@Composable
private fun ChatItem() {
    Row {
        Spacer(modifier = Modifier.size(dimensionResource(id = dimen.avatar_size)))
        Box(Modifier.padding(horizontal = dimensionResource(id = dimen.spacing_16))) {
            ChatBubble(message = "Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World")
        }
    }
}

@Composable
private fun ChatBubble(message: String) {
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier.padding(dimensionResource(id = dimen.spacing_8))
    ) {
        Text(text = message, modifier = Modifier.padding(dimensionResource(id = dimen.spacing_8)))
    }
}
