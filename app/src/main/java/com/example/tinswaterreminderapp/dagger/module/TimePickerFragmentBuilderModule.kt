package com.example.tinswaterreminderapp.dagger.module

import com.example.tinswaterreminderapp.TimePickerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TimePickerFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun injectTimePickerFragment(): TimePickerFragment
}