package com.example.tinswaterreminderapp.di.component

import android.app.Application
import com.example.tinswaterreminderapp.MainApplication
import com.example.tinswaterreminderapp.di.module.ActivityBuilderModule
import com.example.tinswaterreminderapp.di.module.ApplicationModule
import com.example.tinswaterreminderapp.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
/*
* Reference: https://medium.com/@shashankmohabia/dagger-android-with-mvvm-dependency-injection-for-android-3a7e33ad1013
* */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ApplicationModule::class,
        ViewModelFactoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
