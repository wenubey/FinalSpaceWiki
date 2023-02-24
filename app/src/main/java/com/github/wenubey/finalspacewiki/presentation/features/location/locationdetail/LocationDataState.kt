package com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail

import com.github.wenubey.finalspacewiki.domain.model.LocationData

data class LocationDataState(
  val data: LocationData? = null,
  val isLoading: Boolean = false,
  val error: String? = null
)
