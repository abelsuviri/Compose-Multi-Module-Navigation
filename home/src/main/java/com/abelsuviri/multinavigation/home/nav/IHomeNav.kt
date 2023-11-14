package com.abelsuviri.multinavigation.home.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface IHomeNav {
    @Composable fun GetNavHost(
        navController: NavHostController,
        screenTitle: (String) -> Unit
    )

    fun navigateToSettings(navController: NavHostController)
}
