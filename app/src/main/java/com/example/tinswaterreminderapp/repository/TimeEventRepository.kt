package com.example.tinswaterreminderapp.repository

import com.example.tinswaterreminderapp.model.param.TimePickerParam

interface TimeEventRepository {
    fun saveTimeEvent(param: TimePickerParam)
    fun getTimeEvent(): TimePickerParam?
}