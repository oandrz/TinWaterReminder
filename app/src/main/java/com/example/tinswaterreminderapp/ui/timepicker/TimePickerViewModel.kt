package com.example.tinswaterreminderapp.ui.timepicker

import androidx.lifecycle.ViewModel
import com.example.tinswaterreminderapp.data.model.param.TimePickerParam
import com.example.tinswaterreminderapp.usecase.GetTimeEventUseCase
import com.example.tinswaterreminderapp.usecase.SaveTimeEventUseCase
import com.example.tinswaterreminderapp.usecase.SaveTimeFlagUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TimePickerViewModel @Inject constructor(
    private val saveTimeEventUseCase: SaveTimeEventUseCase,
    private val saveTimeFlagUseCase: SaveTimeFlagUseCase,
    private val getTimeEventUseCase: GetTimeEventUseCase
) : ViewModel() {
    private val mutableState: MutableStateFlow<TimePickerState> = MutableStateFlow(TimePickerState.None)
    val state: StateFlow<TimePickerState> = mutableState

    fun handleSubmitButtonClicked() {
        val timeList = mapOf(
            TresholdEvent.LUNCH to getTimeEventUseCase.run(TresholdEvent.LUNCH.name),
            TresholdEvent.DINNER to getTimeEventUseCase.run(TresholdEvent.DINNER.name),
            TresholdEvent.SLEEP to getTimeEventUseCase.run(TresholdEvent.SLEEP.name)
        )
        mutableState.value = TimePickerState.SetAlarm(timeList)
//        mutableState.value = TimePickerState.NavigateScheduleList
    }

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
        mutableState.value = TimePickerState.RenderTimePicker(event, "$hoursOfTheDay:$minute")
    }

    private fun showTimePicker(event: TresholdEvent) {
        saveTimeFlagUseCase.run(true)
        mutableState.value = TimePickerState.ShowTimePicker(event)
    }
}

sealed class TimePickerState {
    object None : TimePickerState()
    class ShowTimePicker(val treshold: TresholdEvent) : TimePickerState()
    class RenderTimePicker(val treshold: TresholdEvent, val time: String) : TimePickerState()
    class SetAlarm(val param: Map<TresholdEvent, TimePickerParam>) : TimePickerState()
    object NavigateScheduleList : TimePickerState()
}

enum class TresholdEvent {
    LUNCH, DINNER, SLEEP
}
