package com.example.mediataggingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingtext: String = "Creating Account...",
    icon: Painter = painterResource(id = R.drawable.google_logo ),
    shape:Shape = CircleShape,
    borderColor:Color = Color.LightGray,
    onClicked: () -> Unit
) {
    Surface() {
        var clicked by remember { mutableStateOf(false) }

        Surface(
            onClick = { clicked = !clicked },
            shape = shape,
            border = BorderStroke(width = 1.dp, color = borderColor ),
            color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 12.dp, end = 16.dp)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Google Button",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(all = 10.dp)
                        .clip(CircleShape)
                )
                Text(text = "SignIn with Google")
                if (clicked){
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = if (clicked) loadingtext else text)
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    onClicked( )
                }
            }
        }
    }
}

@Composable
@Preview
private fun GoogleButtonPreview() {
    GoogleButton(
        text = "Sign Up with Google",
        loadingtext = "Creating Accout...",
        onClicked = { }
    )
}