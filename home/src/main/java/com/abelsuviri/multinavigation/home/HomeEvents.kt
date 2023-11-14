package com.abelsuviri.multinavigation.home

sealed interface HomeEvents {
    sealed interface Navigation : HomeEvents {
        data object Settings : Navigation
    }
}
