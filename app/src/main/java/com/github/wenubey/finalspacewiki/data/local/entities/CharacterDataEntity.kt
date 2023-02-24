package com.github.wenubey.finalspacewiki.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDataEntity (
    @PrimaryKey val uid: Int? = null,
    val id: Int,
    val name: String,
    val status: String,
    val species: String? = null,
    val gender: String,
    val hair: String,
    val alias: List<String>,
    val origin: String,
    val abilities: List<String>,
    val img_url: String,
        )