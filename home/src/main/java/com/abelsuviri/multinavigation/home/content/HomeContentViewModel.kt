package com.abelsuviri.multinavigation.home.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeContentViewModel @Inject constructor() : ViewModel() {
    private val _events = MutableSharedFlow<HomeContentEvents>()
    val events: Flow<HomeContentEvents>
        get() = _events

    fun onEventsButtonClicked() {
        viewModelScope.launch {
            _events.emit(HomeContentEvents.Navigation.Events(1))
        }
    }
}
