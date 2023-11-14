package com.abelsuviri.multinavigation.home.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abelsuviri.multinavigation.home.content.di.provideHomeContentNavEntryPoint
import com.abelsuviri.multinavigation.home.content.nav.IHomeContentNav

@Composable
fun HomeContent(
    navController: NavHostController,
    viewModel: HomeContentViewModel = hiltViewModel(),
    nav: IHomeContentNav = provideHomeContentNavEntryPoint().homeContentNav
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Home")
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Button({ viewModel.onEventsButtonClicked() }) {
            Text("Open Events")
        }
    }

    LaunchedEffect(key1 = null) {
        viewModel.events.collect { event ->
            when (event) {
                is HomeContentEvents.Navigation.Events -> nav.navigateToEvents(navController, event.eventNumber)
            }
        }
    }
}
