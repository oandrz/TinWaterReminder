package com.example.tinswaterreminderapp.di.module

import android.app.Application
import com.example.tinswaterreminderapp.data.datasource.DiskCache
import com.example.tinswaterreminderapp.data.datasource.DiskCacheImpl
import com.example.tinswaterreminderapp.data.datasource.LocalStorage
import com.example.tinswaterreminderapp.data.datasource.LocalStorageImpl
import com.example.tinswaterreminderapp.data.repository.*
import com.example.tinswaterreminderapp.util.serializer.ObjectSerializer
import com.example.tinswaterreminderapp.util.serializer.ObjectSerializerImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun provideDiskCache(diskCacheImpl: DiskCacheImpl): DiskCache

    @Binds
    @Singleton
    abstract fun provideSerializer(impl: ObjectSerializerImpl): ObjectSerializer

    @Binds
    abstract fun provideTimeEventRepository(impl: TimeEventRepositoryImpl): TimeEventRepository

    @Binds
    abstract fun provideScheduleListRepository(impl: ScheduleListRepositoryImpl): ScheduleListRepository

    @Binds
    abstract fun provideUserRepository(impl: UserRepositoryImpl): UserRepository

    companion object {
        @Provides
        @Singleton
        fun provideLocalStorage(application: Application): LocalStorage {
            return LocalStorageImpl(application.applicationContext)
        }

        @Provides
        @Singleton
        fun provideMoshi(): Moshi {
            return Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        }
    }
}
