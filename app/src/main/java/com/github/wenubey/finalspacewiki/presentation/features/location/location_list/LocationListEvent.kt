package com.github.wenubey.finalspacewiki.presentation.features.location.location_list

sealed class LocationListEvent {
  object Refresh: LocationListEvent()
  data class OnSearchQueryChanged(val query: String): LocationListEvent()
}
