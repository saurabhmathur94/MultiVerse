package com.saurabhmathur.multiverse.ui.main

import com.saurabhmathur.multiverse.data.repository.CharacterRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CharacterViewModelTest {

    lateinit var characterRepository:CharacterRepository
    lateinit var characterViewModel: CharacterViewModel

    @Before
    fun setUp() {
        characterRepository = Mockito.mock(CharacterRepository::class.java)
        characterViewModel = CharacterViewModel(characterRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `fetchCharacters must return api data`() {
    }

    @Test
    fun getCharacters() {
    }
}