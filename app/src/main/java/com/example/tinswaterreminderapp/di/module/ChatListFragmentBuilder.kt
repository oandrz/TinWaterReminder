package com.example.tinswaterreminderapp.di.module

import com.example.tinswaterreminderapp.ui.chatlist.ChatListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChatListFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun injectChatListFragment(): ChatListFragment
}
