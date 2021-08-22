package com.example.tinswaterreminderapp.di.module

import com.example.tinswaterreminderapp.MainActivity
import com.example.tinswaterreminderapp.di.module.fragment.ChatListFragmentBuilderModule
import com.example.tinswaterreminderapp.di.module.fragment.ScheduleListFragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
        modules = [
            ChatListFragmentBuilderModule::class,
            ScheduleListFragmentBuilderModule::class,
            ViewModelModule::class
        ]
    )
    abstract fun injectTimePickerActivity(): MainActivity
}
