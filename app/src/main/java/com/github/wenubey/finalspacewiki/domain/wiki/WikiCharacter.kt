package com.github.wenubey.finalspacewiki.domain.wiki

import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto

data class WikiCharacter(
    val data: CharacterDataDto,
    val isFavourite: Boolean = false,
)
