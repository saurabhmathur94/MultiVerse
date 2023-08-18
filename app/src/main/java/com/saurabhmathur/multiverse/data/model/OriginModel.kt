package com.saurabhmathur.multiverse.data.model

import androidx.room.ColumnInfo


data class OriginModel(
    @ColumnInfo(name = "origin_name")
    val name: String,
    @ColumnInfo(name = "origin_url")
    val url: String
)
