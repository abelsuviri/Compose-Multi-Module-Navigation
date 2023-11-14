package com.abelsuviri.multinavigation.settings.nav

sealed class SettingsRoute(
    val title: String,
    val route: String,
) {
    data object Settings : SettingsRoute("Settings", "Settings")
}
