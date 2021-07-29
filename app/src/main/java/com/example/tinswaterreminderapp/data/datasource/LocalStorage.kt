package com.example.tinswaterreminderapp.data.datasource

interface LocalStorage {
    fun getString(key: String): String?

    fun getString(key: String, defaultValue: String?): String?

    fun getBoolean(key: String): Boolean

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun getStringSet(key: String): Set<String>?

    fun getInt(key: String, defaultValue: Int): Int

    fun getLong(key: String, defaultValue: Long): Long

    fun putBoolean(key: String, value: Boolean)

    fun putInt(key: String, value: Int)

    fun putString(key: String, value: String)

    fun putStringSet(key: String, value: Set<String>)

    fun putLong(key: String, value: Long)

    fun remove(key: String)

    fun putFloat(key: String, value: Float)

    fun getFloat(key: String, defaultValue: Float): Float
}
