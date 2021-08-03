package com.example.tinswaterreminderapp.di.module

import com.example.tinswaterreminderapp.ui.schedulelist.ScheduleListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScheduleListFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun injectScheduleListFragment(): ScheduleListFragment
}
