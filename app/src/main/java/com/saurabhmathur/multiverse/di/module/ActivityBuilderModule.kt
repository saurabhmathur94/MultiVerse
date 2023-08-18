package com.saurabhmathur.multiverse.di.module

import com.saurabhmathur.multiverse.ui.details.CharacterDetailActivity
import com.saurabhmathur.multiverse.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
abstract class ActivityBuilderModule {

    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun bindCharacterDetailActivity(): CharacterDetailActivity
}