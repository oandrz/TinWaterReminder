package com.example.tinswaterreminderapp.data.repository

import com.example.tinswaterreminderapp.data.model.Schedule

interface ScheduleListRepository {
    fun getSchedule(): List<Schedule>
}
