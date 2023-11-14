package com.abelsuviri.multinavigation.navigation.host

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abelsuviri.multinavigation.events.EventsScreen
import com.abelsuviri.multinavigation.events.nav.EventsRoute
import com.abelsuviri.multinavigation.home.content.HomeContent
import com.abelsuviri.multinavigation.home.content.nav.HomeNavRoute
import com.abelsuviri.multinavigation.settings.SettingsScreen
import com.abelsuviri.multinavigation.settings.nav.SettingsRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    onNavigation: (String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavRoute.Home.route
    ) {
        composable(HomeNavRoute.Home.route) {
            HomeContent(navController)
            onNavigation(HomeNavRoute.Home.title)
        }

        composable(
            EventsRoute.Events.parameterisedRoute,
            arguments = listOf(navArgument(EventsRoute.Events.parameter) { type = NavType.IntType })
        ) { backStackEntry ->
            EventsScreen(backStackEntry.arguments?.getInt(EventsRoute.Events.parameter) ?: 0)
            onNavigation(EventsRoute.Events.title)
        }

        composable(SettingsRoute.Settings.route) {
            SettingsScreen()
            onNavigation(SettingsRoute.Settings.title)
        }
    }
}
