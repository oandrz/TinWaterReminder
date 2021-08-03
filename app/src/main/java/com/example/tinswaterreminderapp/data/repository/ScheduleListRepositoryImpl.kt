package com.example.tinswaterreminderapp.data.repository

import com.example.tinswaterreminderapp.data.datasource.DiskCache
import com.example.tinswaterreminderapp.data.model.Schedule
import javax.inject.Inject

class ScheduleListRepositoryImpl @Inject constructor(
    private val diskCache: DiskCache
) : ScheduleListRepository {

    override fun getSchedule(): List<Schedule> {
        return emptyList()
    }
}
