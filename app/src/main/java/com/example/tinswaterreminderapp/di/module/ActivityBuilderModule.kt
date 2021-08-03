package com.example.tinswaterreminderapp.di.module

import com.example.tinswaterreminderapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
        modules = [
            TimePickerFragmentBuilderModule::class,
            ScheduleListFragmentBuilderModule::class,
            ViewModelModule::class
        ]
    )
    abstract fun injectTimePickerActivity(): MainActivity
}
