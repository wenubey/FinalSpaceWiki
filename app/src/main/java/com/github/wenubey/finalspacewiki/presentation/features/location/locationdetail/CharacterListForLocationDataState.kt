package com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail

import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.domain.model.LocationData

data class CharacterListForLocationDataState (
  val data: List<CharacterData>? = null,
  val isLoading: Boolean = false,
  val error: String? = null
        )
