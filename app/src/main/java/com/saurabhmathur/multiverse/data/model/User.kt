package com.saurabhmathur.multiverse.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "email")
    var email: String ="",

    @ColumnInfo(name = "name")
    var name: String = ""
)
