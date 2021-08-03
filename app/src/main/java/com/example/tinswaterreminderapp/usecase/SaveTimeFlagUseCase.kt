package com.example.tinswaterreminderapp.usecase

import com.example.tinswaterreminderapp.data.repository.UserRepository
import javax.inject.Inject

class SaveTimeFlagUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun run(isSet: Boolean) = repository.setTimeFlag(isSet)
}
