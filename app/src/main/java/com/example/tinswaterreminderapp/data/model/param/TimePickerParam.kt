package com.example.tinswaterreminderapp.data.model.param

import com.example.tinswaterreminderapp.ui.timepicker.TresholdEvent

data class TimePickerParam(
    val event: TresholdEvent,
    val hoursOfTheDay: Int,
    val minute: Int
)
