package com.example.tinswaterreminderapp.repository

import com.example.tinswaterreminderapp.datasource.DiskCache
import com.example.tinswaterreminderapp.model.param.TimePickerParam
import javax.inject.Inject

class TimeEventRepositoryImpl @Inject constructor(
    private val diskCache: DiskCache
) : TimeEventRepository {

    override fun saveTimeEvent(param: TimePickerParam) {
        diskCache.put(TIME_EVENT_KEY, param, TimePickerParam::class.java)
    }

    override fun getTimeEvent(): TimePickerParam? {
        return diskCache.get(TIME_EVENT_KEY, TimePickerParam::class.java)
    }

    companion object {
        private const val TIME_EVENT_KEY = "TIME_EVENT_KEY"
    }
}