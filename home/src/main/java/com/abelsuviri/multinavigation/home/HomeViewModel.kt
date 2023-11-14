package com.abelsuviri.multinavigation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _events = MutableSharedFlow<HomeEvents>()
    val events: Flow<HomeEvents>
        get() = _events

    fun onSettingsButtonClicked() {
        viewModelScope.launch {
            _events.emit(HomeEvents.Navigation.Settings)
        }
    }
}
