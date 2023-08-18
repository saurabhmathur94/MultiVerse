package com.saurabhmathur.multiverse.data.remote

import com.saurabhmathur.multiverse.data.model.CharacterList
import retrofit2.http.GET

interface MultiverseApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterList

    companion object{
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}