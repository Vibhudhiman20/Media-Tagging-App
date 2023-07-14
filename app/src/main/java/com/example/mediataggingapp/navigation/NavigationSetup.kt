package com.example.mediataggingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mediataggingapp.screens.AboutScreen
import com.example.mediataggingapp.screens.HomeScreen
import com.example.mediataggingapp.screens.SettingsScreen

@Composable
fun NavigationSetup(navController: NavHostController) {

    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Shared.screen_route) {
            AboutScreen()
        }
        composable(BottomNavItem.My_File.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Notification.screen_route) {
            AboutScreen()
        }

    }

    /*NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
    }*/
}