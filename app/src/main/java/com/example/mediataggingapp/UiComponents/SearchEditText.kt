package com.example.mediataggingapp.UiComponents

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchEditText(
    hintText: String = "Search",
    loadingtext: String = "Searching...",
    onClicked: () -> Unit
){

    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = "profileIcon") },
        onValueChange = { text = it },
        label = { Text(text = hintText) },
        placeholder = { Text(text = "Search what you want to") },
        shape = RoundedCornerShape(30.dp),

    )

}

@Composable
@Preview
private fun TextFieldPreview() {
    SearchEditText(
        hintText = "Search",
        loadingtext = "Searching...",
        onClicked = { }
    )
}