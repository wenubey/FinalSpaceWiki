package com.github.wenubey.finalspacewiki.presentation

import com.github.wenubey.finalspacewiki.data.remote.CharactersDataDto

data class ListDataState(
    val data: CharactersDataDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

