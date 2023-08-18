package com.saurabhmathur.multiverse.data.model

import androidx.room.*

@Entity(tableName = "character")
data class Character(
    @PrimaryKey
    val id: Int,
    val created: String,
    val url: String,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded
    val origin: OriginModel,
    @Embedded
    val location: LocationModel
)

