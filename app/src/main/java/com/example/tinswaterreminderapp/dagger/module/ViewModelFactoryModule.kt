package com.example.tinswaterreminderapp.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.example.tinswaterreminderapp.dagger.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}