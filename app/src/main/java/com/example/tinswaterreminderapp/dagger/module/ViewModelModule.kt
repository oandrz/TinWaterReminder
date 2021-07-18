package com.example.tinswaterreminderapp.dagger.module

import androidx.lifecycle.ViewModel
import com.example.tinswaterreminderapp.TimePickerViewModel
import com.example.tinswaterreminderapp.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TimePickerViewModel::class)
    abstract fun bindTimePickerViewModel(vm: TimePickerViewModel): ViewModel
}