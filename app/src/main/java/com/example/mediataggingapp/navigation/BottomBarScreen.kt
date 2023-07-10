package com.example.mediataggingapp.navigation

import com.example.mediataggingapp.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.outline_home,
        icon_focused = R.drawable.add_icon
    )
    object Report: BottomBarScreen(
        route = "report",
        title = "Report",
        icon = R.drawable.outline_notes,
        icon_focused = R.drawable.add_icon
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile_default,
        icon_focused = R.drawable.add_icon
    )
}
