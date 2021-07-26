package com.example.tinswaterreminderapp.model.param

import com.example.tinswaterreminderapp.timepicker.TresholdEvent

data class TimePickerParam(
    val event: TresholdEvent,
    val hoursOfTheDay: Int,
    val minute: Int
)