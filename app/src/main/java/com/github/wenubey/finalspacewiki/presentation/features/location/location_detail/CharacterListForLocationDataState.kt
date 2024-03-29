package com.github.wenubey.finalspacewiki.presentation.features.location.location_detail

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class CharacterListForLocationDataState (
  val data: List<CharacterData>? = null,
  val isLoading: Boolean = false,
  val error: String? = null
        )
