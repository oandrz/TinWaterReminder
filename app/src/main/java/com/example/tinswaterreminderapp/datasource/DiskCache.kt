package com.example.tinswaterreminderapp.datasource

interface DiskCache {
    fun <T> get(key: String, type: Class<T>): T?

    fun <T> put(key: String, value: T, classOfT: Class<T>)

    fun remove(key: String)
}