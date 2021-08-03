package com.example.tinswaterreminderapp.usecase

import com.example.tinswaterreminderapp.data.repository.UserRepository
import javax.inject.Inject

class GetTimeFlagUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun run() = repository.isTimeAlreadySet
}
