package com.abelsuviri.multinavigation.navigation

import androidx.navigation.NavHostController
import com.abelsuviri.multinavigation.events.nav.EventsRoute
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class HomeContentNavTest {

    private val navController = mockk<NavHostController>()
    private lateinit var homeContentNav: HomeContentNav

    @Before
    fun setup() {
        homeContentNav = HomeContentNav()
    }

    @Test
    fun `when navigate to events called, perform navigation`() {
        every { navController.navigate(route = any()) } just  Runs

        homeContentNav.navigateToEvents(navController, 1)

        verify { navController.navigate("${EventsRoute.Events.route}/1") }
    }
}