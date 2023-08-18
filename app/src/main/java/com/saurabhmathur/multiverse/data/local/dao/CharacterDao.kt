package com.saurabhmathur.multiverse.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saurabhmathur.multiverse.data.model.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun loadAllCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM character WHERE id=:characterId")
    fun loadCharacterById(characterId: Int): LiveData<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(character: List<Character>)

}