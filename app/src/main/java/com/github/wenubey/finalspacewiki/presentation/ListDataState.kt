package com.github.wenubey.finalspacewiki.presentation

import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto

data class ListDataState(
    val data: List<CharacterDataDto>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

