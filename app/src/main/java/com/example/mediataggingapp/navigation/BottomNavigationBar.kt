package com.example.mediataggingapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mediataggingapp.R


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
//    val route: String,
//    @StringRes val titleResId: Int,
//    @DrawableRes val icon: Int
//    ) {
    /*object Home : BottomNavItem(
        route = Screen.Home.route,
        titleResId = R.string.screen_title_home,
        icon = R.drawable.default_home
    )

    object Settings : BottomNavItem(
        route = Screen.Settings.route,
        titleResId = R.string.screen_title_settings,
        icon = R.drawable.default_shared
    )*/
    object Home : BottomNavItem("Home", R.drawable.default_home,"home")
    object Shared: BottomNavItem("Shared",R.drawable.default_shared,"shared")
    object My_File: BottomNavItem("My File",R.drawable.outline_folder_default,"my_file")
    object Notification: BottomNavItem("Notification",R.drawable.default_notification,"notification")
}

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Shared,
        BottomNavItem.My_File,
        BottomNavItem.Notification
    )

    BottomNavigation( backgroundColor = Color(0xCB90B4E9)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier.padding(top = 10.dp),
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.DarkGray,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}