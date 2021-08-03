package com.example.tinswaterreminderapp.data.repository

interface UserRepository {
    val isTimeAlreadySet: Boolean
    fun setTimeFlag(isSet: Boolean)
}
