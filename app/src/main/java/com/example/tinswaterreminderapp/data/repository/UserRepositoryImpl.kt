package com.example.tinswaterreminderapp.data.repository

import com.example.tinswaterreminderapp.data.datasource.LocalStorage
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localStorage: LocalStorage
) : UserRepository {

    override val isTimeAlreadySet: Boolean
        get() = localStorage.getBoolean(CACHE_KEY_TIME)

    override fun setTimeFlag(isSet: Boolean) {
        localStorage.putBoolean(CACHE_KEY_TIME, isSet)
    }

    companion object {
        private const val CACHE_KEY_TIME = "CACHE_KEY_TIME"
    }
}
