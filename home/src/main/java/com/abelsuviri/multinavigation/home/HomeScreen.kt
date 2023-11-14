package com.abelsuviri.multinavigation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abelsuviri.multinavigation.home.di.provideHomeNavEntryPoint
import com.abelsuviri.multinavigation.home.nav.IHomeNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    nav: IHomeNav = provideHomeNavEntryPoint().homeNav,
) {
    val navController = rememberNavController()
    var screenTitle by remember { mutableStateOf("Home") }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val showBackButton by remember(currentBackStackEntry) {
        derivedStateOf { navController.previousBackStackEntry != null }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                title = { Text(screenTitle) },
                actions = {
                    IconButton(onClick = { viewModel.onSettingsButtonClicked() }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings Button"
                        )
                    }
                },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back button"
                            )
                        }
                    }
                },
            )
        },
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            nav.GetNavHost(navController) { title ->
                screenTitle = title
            }
        }
    }

    LaunchedEffect(key1 = null) {
        viewModel.events.collect { event ->
            when (event) {
                HomeEvents.Navigation.Settings -> nav.navigateToSettings(navController)
            }
        }
    }
}
