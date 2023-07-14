package com.example.mediataggingapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mediataggingapp.navigation.BottomNavigationBar
import com.example.mediataggingapp.navigation.NavigationSetup
import com.example.mediataggingapp.ui.theme.MediaTaggingAppTheme

class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTaggingAppTheme {
                Surface {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController) }
                    ) {
                        NavigationSetup(navController = navController)
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MediaTaggingAppTheme {

    }
}