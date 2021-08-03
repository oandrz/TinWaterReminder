package com.example.tinswaterreminderapp.di.module

import androidx.lifecycle.ViewModel
import com.example.tinswaterreminderapp.ui.timepicker.TimePickerViewModel
import com.example.tinswaterreminderapp.di.ViewModelKey
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
