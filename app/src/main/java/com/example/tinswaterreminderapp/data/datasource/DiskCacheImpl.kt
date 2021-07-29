package com.example.tinswaterreminderapp.data.datasource

import com.example.tinswaterreminderapp.util.serializer.ObjectSerializer
import javax.inject.Inject

class DiskCacheImpl @Inject constructor(
    private val localStorage: LocalStorage,
    private val serializer: ObjectSerializer
) : DiskCache {

    override fun <T> get(key: String, type: Class<T>): T? {
        val json = localStorage.getString(key)
        return json?.let { serializer.deSerialize(it, type) }
    }

    override fun <T> put(key: String, value: T, classOfT: Class<T>) {
        val json = serializer.serialize(value, classOfT)
        localStorage.putString(key, json!!)
    }

    override fun remove(key: String) {
        localStorage.remove(key)
    }
}
