package com.abelsuviri.multinavigation.navigation.di

import com.abelsuviri.multinavigation.home.content.nav.IHomeContentNav
import com.abelsuviri.multinavigation.home.nav.IHomeNav
import com.abelsuviri.multinavigation.navigation.HomeContentNav
import com.abelsuviri.multinavigation.navigation.HomeNav
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {
    @Binds
    abstract fun bindHomeNav(homeNav: HomeNav): IHomeNav

    @Binds
    abstract fun bindHomeContentNav(homeContentNav: HomeContentNav): IHomeContentNav
}
