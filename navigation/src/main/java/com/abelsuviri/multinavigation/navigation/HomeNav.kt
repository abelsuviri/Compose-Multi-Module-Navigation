package com.abelsuviri.multinavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.abelsuviri.multinavigation.home.nav.IHomeNav
import com.abelsuviri.multinavigation.navigation.host.AppNavHost
import com.abelsuviri.multinavigation.settings.nav.SettingsRoute
import javax.inject.Inject

class HomeNav @Inject constructor() : IHomeNav {
    @Composable
    override fun GetNavHost(navController: NavHostController, screenTitle: (String) -> Unit) {
        AppNavHost(navController, screenTitle)
    }

    override fun navigateToSettings(navController: NavHostController) {
        navController.navigate(SettingsRoute.Settings.route)
    }
}
