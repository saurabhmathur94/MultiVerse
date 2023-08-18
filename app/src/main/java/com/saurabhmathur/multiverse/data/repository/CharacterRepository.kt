package com.saurabhmathur.multiverse.data.repository

import com.saurabhmathur.multiverse.data.local.dao.CharacterDao
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.data.remote.MultiverseApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterDao: CharacterDao,
    private val multiverseApiService: MultiverseApiService
) {
    suspend fun getCharacters() = multiverseApiService.getCharacters()

    fun getCharacterById(characterId: Int) = characterDao.loadCharacterById(characterId)

    fun loadAllCharactersFromDB() = characterDao.loadAllCharacters()

    suspend fun insertCharactersInDB(character: List<Character>) = characterDao.insertCharacters(character)
}