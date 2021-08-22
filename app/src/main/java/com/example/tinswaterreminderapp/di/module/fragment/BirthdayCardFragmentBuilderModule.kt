package com.example.tinswaterreminderapp.di.module.fragment

import com.example.tinswaterreminderapp.ui.brithday.BirthdayCardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BirthdayCardFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun injectBirthdayCardFragment(): BirthdayCardFragment
}
