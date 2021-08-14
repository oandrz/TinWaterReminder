package com.example.tinswaterreminderapp.data.repository

import com.example.tinswaterreminderapp.data.datasource.DiskCache
import com.example.tinswaterreminderapp.data.model.param.TimePickerParam
import javax.inject.Inject

class TimeEventRepositoryImpl @Inject constructor(
    private val diskCache: DiskCache
) : TimeEventRepository {

    override fun saveTimeEvent(param: TimePickerParam) {
        diskCache.put(param.event.name, param, TimePickerParam::class.java)
    }

    override fun getTimeEvent(eventName: String): TimePickerParam? {
        return diskCache.get(eventName, TimePickerParam::class.java)
    }
}
