package com.example.mediataggingapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Screen", fontSize = 20.sp)
    }
}