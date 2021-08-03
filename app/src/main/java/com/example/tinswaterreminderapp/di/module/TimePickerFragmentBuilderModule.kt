package com.example.tinswaterreminderapp.di.module

import com.example.tinswaterreminderapp.ui.timepicker.TimePickerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TimePickerFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun injectTimePickerFragment(): TimePickerFragment
}
