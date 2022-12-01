package com.github.wenubey.finalspacewiki.data.remote

import com.squareup.moshi.Json

data class CharactersDataDto(
    @field:Json(name = "")
    val characters: List<CharacterDataDto>
)
