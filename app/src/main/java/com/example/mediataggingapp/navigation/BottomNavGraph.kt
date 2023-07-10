package com.example.mediataggingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mediataggingapp.screens.HomeScreen
import com.example.mediataggingapp.screens.ProfileScreen
import com.example.mediataggingapp.screens.ReportScreen


@Composable
fun BottomNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Report.route){
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}

