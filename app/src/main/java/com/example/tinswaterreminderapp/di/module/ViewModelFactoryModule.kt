package com.example.tinswaterreminderapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.tinswaterreminderapp.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
