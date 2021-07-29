package com.example.tinswaterreminderapp.usecase

import com.example.tinswaterreminderapp.data.model.param.TimePickerParam
import com.example.tinswaterreminderapp.data.repository.TimeEventRepository
import javax.inject.Inject

class SaveTimeEventUseCase @Inject constructor(
    private val repository: TimeEventRepository
) {
    fun run(param: TimePickerParam) {
        repository.saveTimeEvent(param)
    }
}
