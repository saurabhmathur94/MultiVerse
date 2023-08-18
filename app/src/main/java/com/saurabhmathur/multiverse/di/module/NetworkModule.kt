package com.saurabhmathur.multiverse.di.module

import com.saurabhmathur.multiverse.data.remote.MultiverseApiService
import com.saurabhmathur.multiverse.data.remote.Networking
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): MultiverseApiService = Networking.buildRetrofit()

}