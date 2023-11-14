package com.abelsuviri.multinavigation.home.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.abelsuviri.multinavigation.home.nav.IHomeNav
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

private lateinit var homeNavEntryPoint: HomeNavEntryPoint

@Composable
fun provideHomeNavEntryPoint(): HomeNavEntryPoint {
    if (!::homeNavEntryPoint.isInitialized) {
        homeNavEntryPoint = EntryPoints.get(
            LocalContext.current.applicationContext,
            HomeNavEntryPoint::class.java
        )
    }

    return homeNavEntryPoint
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HomeNavEntryPoint {
    val homeNav: IHomeNav
}
