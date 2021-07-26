package com.example.tinswaterreminderapp.usecase

import com.example.tinswaterreminderapp.model.param.TimePickerParam
import com.example.tinswaterreminderapp.repository.TimeEventRepository
import javax.inject.Inject

class SaveTimeEventUseCase @Inject constructor(
    private val repository: TimeEventRepository
) {
    fun run(param: TimePickerParam) {
        repository.saveTimeEvent(param)
    }
}
