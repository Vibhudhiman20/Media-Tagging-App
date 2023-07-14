package com.example.mediataggingapp.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mediataggingapp.UiComponents.FolderRVItem
import com.example.mediataggingapp.UiComponents.SearchEditText
import com.example.mediataggingapp.data.FolderDataDetail
import com.example.mediataggingapp.data.FolderDetails
import com.google.gson.Gson

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    /*Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween) {

        //All elements
        Column {

            // RED BOX

            //...
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Green)
                    .height(15.dp)
            )

            //... Green box
        }

        //LAST ROW
        Row(
            modifier = Modifier
                .weight(1f, false)
        ) {
            //...
        }
    }*/
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchEditText(
            hintText = "Search",
            loadingtext = "Searching wait",
            onClicked = {
                Log.e("vibhu", "HomeScreen: on clickkk")
            }
        )
        NavigatePage()
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