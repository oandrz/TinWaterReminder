package com.example.tinswaterreminderapp.datasource

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class LocalStorageImpl : LocalStorage {

    private var sharedPreferences: SharedPreferences

    constructor(context: Context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    constructor(context: Context, preferenceName: String) {
        this.sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    override fun getString(key: String): String? {
        return getString(key, null)
    }

    override fun getString(key: String, defaultValue: String?): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    override fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    override fun getStringSet(key: String): Set<String>? {
        return sharedPreferences.getStringSet(key, null)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    override fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun putStringSet(key: String, value: Set<String>) {
        sharedPreferences.edit().putStringSet(key, value).apply()
    }

    override fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    override fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }
}