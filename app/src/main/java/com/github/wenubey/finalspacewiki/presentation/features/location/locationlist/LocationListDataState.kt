package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import com.github.wenubey.finalspacewiki.domain.model.LocationData

data class LocationListDataState(
  val locations: List<LocationData> = emptyList(),
  val isLoading: Boolean =false,
  val error: String? = null
)