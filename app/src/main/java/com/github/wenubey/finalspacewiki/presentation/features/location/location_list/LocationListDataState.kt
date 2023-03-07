package com.github.wenubey.finalspacewiki.presentation.features.location.location_list

import com.github.wenubey.finalspacewiki.domain.model.LocationData

data class LocationListDataState(
  val locations: List<LocationData>? = null,
  val isLoading: Boolean =false,
  val isRefreshing: Boolean = false,
  val error: String? = null
)