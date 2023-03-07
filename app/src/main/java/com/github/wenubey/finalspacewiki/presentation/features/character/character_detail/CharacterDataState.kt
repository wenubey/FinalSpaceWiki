package com.github.wenubey.finalspacewiki.presentation.features.character.character_detail

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class CharacterDataState(
    val data: CharacterData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)