package com.example.tinswaterreminderapp.usecase

import com.example.tinswaterreminderapp.model.param.TimePickerParam
import com.example.tinswaterreminderapp.repository.TimeEventRepository
import javax.inject.Inject

class GetTimeEventUseCase @Inject constructor(
    private val repository: TimeEventRepository
) {

    fun run(): TimePickerParam? {
        return repository.getTimeEvent()
    }
}