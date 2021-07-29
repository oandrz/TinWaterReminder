package com.example.tinswaterreminderapp.ui.timepicker

import androidx.lifecycle.ViewModel
import com.example.tinswaterreminderapp.data.model.param.TimePickerParam
import com.example.tinswaterreminderapp.usecase.SaveTimeEventUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TimePickerViewModel @Inject constructor(
    private val saveTimeEventUseCase: SaveTimeEventUseCase
) : ViewModel() {
    private val mutableState: MutableStateFlow<TimePickerState> = MutableStateFlow(TimePickerState.None)
    val state: StateFlow<TimePickerState> = mutableState

    fun handleEtSleepTime() {
        showTimePicker(TresholdEvent.SLEEP)
    }

    fun handleEtDinnerTime() {
        showTimePicker(TresholdEvent.DINNER)
    }

    fun handleEtLunchTime() {
        showTimePicker(TresholdEvent.LUNCH)
    }

    fun handleTimePickerSet(event: TresholdEvent, hoursOfTheDay: Int, minute: Int) {
        saveTimeEventUseCase.run(TimePickerParam(event, hoursOfTheDay, minute))
    }

    private fun showTimePicker(event: TresholdEvent) {
        mutableState.value = TimePickerState.ShowTimePicker(event)
    }
}

sealed class TimePickerState {
    object None: TimePickerState()
    class ShowTimePicker(val treshold: TresholdEvent) : TimePickerState()
}

enum class TresholdEvent {
    LUNCH, DINNER, SLEEP
}
