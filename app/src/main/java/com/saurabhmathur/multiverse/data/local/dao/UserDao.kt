package com.saurabhmathur.multiverse.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saurabhmathur.multiverse.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun loadAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user")
    fun loadUserName(): LiveData<User>

    @Query("SELECT * FROM user")
    fun loadUserEmail(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: List<User>)

}