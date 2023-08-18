package com.saurabhmathur.multiverse

import android.app.Application
import com.saurabhmathur.multiverse.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MultiverseApp: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        // Initialize Dependency Injection
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}