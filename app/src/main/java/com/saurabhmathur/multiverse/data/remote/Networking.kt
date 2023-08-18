package com.saurabhmathur.multiverse.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    fun buildRetrofit(): MultiverseApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(MultiverseApiService::class.java)
    }
}