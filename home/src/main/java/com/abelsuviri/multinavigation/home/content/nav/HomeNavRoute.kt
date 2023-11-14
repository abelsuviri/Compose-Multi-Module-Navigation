package com.abelsuviri.multinavigation.home.content.nav

sealed class HomeNavRoute(
    val title: String,
    val route: String
) {
    data object Home : HomeNavRoute("Home", "Home")
}
