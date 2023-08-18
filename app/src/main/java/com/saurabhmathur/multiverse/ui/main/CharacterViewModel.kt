package com.saurabhmathur.multiverse.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.data.repository.CharacterRepository
import com.saurabhmathur.multiverse.utils.State
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
    ): ViewModel() {

    private val characterList = MutableLiveData<State<List<Character>>>()

    init {
        fetchCharacters()
    }

    internal fun fetchCharacters() {
            viewModelScope.launch {
               characterList.postValue(State.loading())
                try {
                    val response = characterRepository.getCharacters()
                    characterList.postValue(State.success(response.results))

                    //Save character list in Database
                    characterRepository.insertCharactersInDB(response.results)
                } catch (e: Exception) {
                    characterList.postValue(State.error(e.message.toString()))
                }
            }
        }

    fun getCharacters(): LiveData<State<List<Character>>> {
        return characterList
    }

}