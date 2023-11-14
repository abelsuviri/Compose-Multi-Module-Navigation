package com.abelsuviri.multinavigation.events.nav

sealed class EventsRoute(
    val title: String,
    val route: String,
    val parameterisedRoute: String,
    val parameter: String
) {
    data object Events : EventsRoute("Events", "Events", "Events/{eventsCount}", "eventsCount")
}
