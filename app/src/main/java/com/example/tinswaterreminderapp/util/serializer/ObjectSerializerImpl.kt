package com.example.tinswaterreminderapp.util.serializer

import com.squareup.moshi.Moshi
import javax.inject.Inject

class ObjectSerializerImpl @Inject constructor(
    private val moshi: Moshi
) : ObjectSerializer {

    override fun <T> serialize(someObj: T, classOfT: Class<T>): String? {
        val adapter = moshi.adapter(classOfT)
        return adapter.toJson(someObj)
    }

    override fun <T> deSerialize(json: String, classOfT: Class<T>): T {
        val adapter = moshi.adapter(classOfT)
        return adapter.fromJson(json)!!
    }
}