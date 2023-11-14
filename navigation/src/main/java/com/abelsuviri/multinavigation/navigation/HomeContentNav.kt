package com.abelsuviri.multinavigation.navigation

import androidx.navigation.NavHostController
import com.abelsuviri.multinavigation.events.nav.EventsRoute
import com.abelsuviri.multinavigation.home.content.nav.IHomeContentNav
import javax.inject.Inject

class HomeContentNav @Inject constructor() : IHomeContentNav {
    override fun navigateToEvents(navController: NavHostController, eventNumber: Int) {
        navController.navigate("${EventsRoute.Events.route}/$eventNumber")
    }
}
