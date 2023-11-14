package com.abelsuviri.multinavigation.navigation

import androidx.navigation.NavHostController
import com.abelsuviri.multinavigation.settings.nav.SettingsRoute
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class HomeNavTest {

    private val navController = mockk<NavHostController>()
    private lateinit var homeNav: HomeNav

    @Before
    fun setup() {
        homeNav = HomeNav()
    }

    @Test
    fun `when navigate to settings called, navigate to settings`() {
        every { navController.navigate(route = any()) } just Runs

        homeNav.navigateToSettings(navController)

        verify { navController.navigate(SettingsRoute.Settings.route) }
    }
}