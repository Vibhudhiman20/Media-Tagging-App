package com.example.mediataggingapp.UiComponents

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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

@OptIn(ExperimentalMaterial3Api::class)
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