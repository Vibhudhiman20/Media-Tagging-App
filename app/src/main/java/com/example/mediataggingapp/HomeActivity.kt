package com.example.mediataggingapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mediataggingapp.UiComponents.FolderRVItem
import com.example.mediataggingapp.UiComponents.SearchEditText
import com.example.mediataggingapp.data.FolderDataDetail
import com.example.mediataggingapp.data.FolderDetails
import com.example.mediataggingapp.navigation.BottomNav
import com.example.mediataggingapp.ui.theme.MediaTaggingAppTheme
import com.google.gson.Gson

class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTaggingAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Surface(color = MaterialTheme.colorScheme.onBackground) {
                        BottomNav()
                    }
                }
                /*Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SearchEditText(
                        hintText = "Search",
                        loadingtext = "Searching wait",
                        onClicked = {
                            Toast.makeText(applicationContext, "Textfield", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
//                    NavigatePage()
                    Column(
                        modifier = Modifier
                            .padding(all = 30.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(color = MaterialTheme.colorScheme.onBackground) {
                            BottomNav()
                        }
                    }

                }
*/            }
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun NavigatePage() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = "folder data"
    ) {
        composable("folder data") {
            FolderRVItem(navController = navHostController)
        }
        composable(
            "grid_detail/{item}",
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry?.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, FolderDetails::class.java)
                FolderDataDetail(data = item)

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