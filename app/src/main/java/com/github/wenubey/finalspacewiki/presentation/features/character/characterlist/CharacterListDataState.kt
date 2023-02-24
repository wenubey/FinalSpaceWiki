package com.github.wenubey.finalspacewiki.presentation.features.character.characterlist

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class CharacterListDataState(
    val characters: List<CharacterData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

