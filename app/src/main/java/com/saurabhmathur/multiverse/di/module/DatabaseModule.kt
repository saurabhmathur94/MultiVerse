package com.saurabhmathur.multiverse.di.module

import android.app.Application
import com.saurabhmathur.multiverse.data.local.MultiverseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseService(application: Application) =
        MultiverseDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideCharacterDao(database: MultiverseDatabase) = database.getCharacterDao()
}