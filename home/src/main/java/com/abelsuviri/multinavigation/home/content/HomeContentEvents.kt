package com.abelsuviri.multinavigation.home.content

sealed interface HomeContentEvents {
    sealed interface Navigation : HomeContentEvents {
        data class Events(val eventNumber: Int) : Navigation
    }
}
