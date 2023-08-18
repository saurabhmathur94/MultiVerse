package com.saurabhmathur.multiverse.di.module

import androidx.lifecycle.ViewModelProvider
import com.saurabhmathur.multiverse.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}