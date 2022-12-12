package com.github.wenubey.finalspacewiki.presentation.wikilist

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class ListDataState(
    val characters: List<CharacterData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

