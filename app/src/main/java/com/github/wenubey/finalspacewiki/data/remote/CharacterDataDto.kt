package com.github.wenubey.finalspacewiki.data.remote

import com.squareup.moshi.Json

data class CharacterDataDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "species")
    val species: String,
    @field:Json(name = "gender")
    val gender: String,
    @field:Json(name = "hair")
    val hair: String,
    @field:Json(name = "alias")
    val alias: List<String>,
    @field:Json(name = "origin")
    val origin: String,
    @field:Json(name = "abilities")
    val abilities: List<String>,
    @field:Json(name = "img_url")
    val img_url: String,
    val isFavourite: Boolean = false,
)


