package com.example.tinswaterreminderapp.di.module

import androidx.lifecycle.ViewModel
import com.example.tinswaterreminderapp.ui.chatlist.ChatListViewModel
import com.example.tinswaterreminderapp.di.ViewModelKey
import com.example.tinswaterreminderapp.ui.brithday.BirthdayCardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatListViewModel::class)
    abstract fun bindTimePickerViewModel(vm: ChatListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BirthdayCardViewModel::class)
    abstract fun bindBirthdayCardViewModel(vm: BirthdayCardViewModel): ViewModel
}
