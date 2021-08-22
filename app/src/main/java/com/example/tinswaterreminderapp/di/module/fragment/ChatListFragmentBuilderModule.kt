package com.example.tinswaterreminderapp.di.module.fragment

import com.example.tinswaterreminderapp.ui.chatlist.ChatListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChatListFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun injectChatListFragment(): ChatListFragment
}
