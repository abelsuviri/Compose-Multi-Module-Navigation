package com.abelsuviri.multinavigation.home.content.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.abelsuviri.multinavigation.home.content.nav.IHomeContentNav
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

private lateinit var homeContentNavEntryPoint: HomeContentNavEntryPoint

@Composable
fun provideHomeContentNavEntryPoint(): HomeContentNavEntryPoint {
    if (!::homeContentNavEntryPoint.isInitialized) {
        homeContentNavEntryPoint = EntryPoints.get(
            LocalContext.current.applicationContext,
            HomeContentNavEntryPoint::class.java
        )
    }

    return homeContentNavEntryPoint
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HomeContentNavEntryPoint {
    val homeContentNav: IHomeContentNav
}
