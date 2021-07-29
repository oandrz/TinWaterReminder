package com.example.tinswaterreminderapp.data.repository

import com.example.tinswaterreminderapp.data.model.param.TimePickerParam

interface TimeEventRepository {
    fun saveTimeEvent(param: TimePickerParam)
    fun getTimeEvent(): TimePickerParam?
}
