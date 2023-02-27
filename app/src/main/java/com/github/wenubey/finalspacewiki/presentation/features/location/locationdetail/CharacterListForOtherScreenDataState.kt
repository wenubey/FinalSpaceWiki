package com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class CharacterListForOtherScreenDataState (
  val data: List<CharacterData>? = null,
  val isLoading: Boolean = false,
  val error: String? = null
        )
