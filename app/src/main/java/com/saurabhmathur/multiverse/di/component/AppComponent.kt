package com.saurabhmathur.multiverse.di.component

import android.app.Application
import com.saurabhmathur.multiverse.MultiverseApp
import com.saurabhmathur.multiverse.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ViewModelFactoryModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MultiverseApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(app: MultiverseApp)
}