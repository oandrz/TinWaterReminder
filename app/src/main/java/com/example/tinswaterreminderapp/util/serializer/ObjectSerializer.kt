package com.example.tinswaterreminderapp.util.serializer

interface ObjectSerializer {
    fun <T> serialize(someObj: T, classOfT: Class<T>): String?

    fun <T> deSerialize(json: String, classOfT: Class<T>): T
}