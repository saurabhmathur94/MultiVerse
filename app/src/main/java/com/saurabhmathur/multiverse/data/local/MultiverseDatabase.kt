package com.saurabhmathur.multiverse.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saurabhmathur.multiverse.data.local.dao.CharacterDao
import com.saurabhmathur.multiverse.data.model.Character
import com.saurabhmathur.multiverse.data.model.User

@Database(
    entities = [Character::class],
    version = 1
)
abstract class MultiverseDatabase: RoomDatabase() {

    abstract fun getCharacterDao() : CharacterDao

    companion object {
        private const val DB_NAME = "multiverse_database"

        @Volatile
        private var INSTANCE: MultiverseDatabase? = null

        fun getInstance(context: Context): MultiverseDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MultiverseDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}