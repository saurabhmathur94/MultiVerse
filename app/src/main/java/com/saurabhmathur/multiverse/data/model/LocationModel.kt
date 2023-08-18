package com.saurabhmathur.multiverse.data.model

import androidx.room.ColumnInfo

data class LocationModel(
    @ColumnInfo(name = "location_name")
    val name: String,
    @ColumnInfo(name = "location_url")
    val url: String
)
