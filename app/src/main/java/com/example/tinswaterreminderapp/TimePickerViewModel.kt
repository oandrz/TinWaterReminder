package com.example.tinswaterreminderapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TimePickerViewModel @Inject constructor() : ViewModel() {
    private val mutableState: MutableStateFlow<TimePickerState> = MutableStateFlow(TimePickerState.None)
    val state: StateFlow<TimePickerState> = mutableState

    fun handleEtSleepTime() {
        showTimePicker(TressholdEvent.SLEEP)
    }

    fun handleEtDinnerTime() {
        showTimePicker(TressholdEvent.DINNER)
    }

    fun handleEtLunchTime() {
        showTimePicker(TressholdEvent.LUNCH)
    }

    fun handleTimePickerSet(event: TressholdEvent, hoursOfTheDay: Int, minute: Int) {

    }

    private fun showTimePicker(event: TressholdEvent) {
        mutableState.value = TimePickerState.ShowTimePicker(event)
    }
}

sealed class TimePickerState {
    object None: TimePickerState()
    class ShowTimePicker(val tresshold: TressholdEvent) : TimePickerState()
}

enum class TressholdEvent {
    LUNCH, DINNER, SLEEP
}