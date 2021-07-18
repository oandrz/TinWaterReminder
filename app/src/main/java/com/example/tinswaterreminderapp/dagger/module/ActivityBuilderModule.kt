package com.example.tinswaterreminderapp.dagger.module

import com.example.tinswaterreminderapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
        modules = [TimePickerFragmentBuilderModule::class, ViewModelModule::class]
    )
    abstract fun injectTimePickerActivity(): MainActivity
}