package com.github.wenubey.finalspacewiki.domain.model

import com.squareup.moshi.Json

data class CharacterData(
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
