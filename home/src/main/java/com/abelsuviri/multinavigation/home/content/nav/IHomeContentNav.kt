package com.abelsuviri.multinavigation.home.content.nav

import androidx.navigation.NavHostController

interface IHomeContentNav {
    fun navigateToEvents(navController: NavHostController, eventNumber: Int)
}
