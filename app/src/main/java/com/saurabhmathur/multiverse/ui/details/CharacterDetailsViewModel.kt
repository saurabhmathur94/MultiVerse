package com.saurabhmathur.multiverse.ui.details

import androidx.lifecycle.ViewModel
import com.saurabhmathur.multiverse.data.repository.CharacterRepository
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val characterRepository: CharacterRepository): ViewModel() {

        fun getCharacter(characterId: Int) = characterRepository.getCharacterById(characterId)
}