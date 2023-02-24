package com.github.wenubey.finalspacewiki.presentation.features.location

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail.LocationDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.locationlist.LocationListDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
  private val repository: WikiRepository,
) : ViewModel() {

  var locationDataState by mutableStateOf(LocationDataState())
    private set

  var locationListDataState by mutableStateOf(LocationListDataState())
    private set

  init {
    loadLocationsList(true)
  }

  fun loadLocationsList(fetchFromRemote: Boolean = false) {
    viewModelScope.launch {
      repository
        .getLocationsData(fetchFromRemote = fetchFromRemote)
        .collect { result ->
          when (result) {
            is Resource.Success -> {
              result.data?.let { locations ->
                locationListDataState = locationListDataState.copy(
                  locations = locations
                )
              }
            }
            is Resource.Loading -> {
              locationListDataState = locationListDataState.copy(
                isLoading = result.isLoading
              )
            }
            //TODO: ADD ERROR SCREEN
            is Resource.Error -> Unit
          }
        }
    }
  }

  fun loadLocation(
    id: Int,
    fetchFromRemote: Boolean = false,
  ) {
    viewModelScope.launch {
      repository
        .getLocationData(id = id, fetchFromRemote = fetchFromRemote)
        .collect { result ->
          when(result) {
            is Resource.Success -> {
              locationDataState = locationDataState.copy(
                data = result.data
              )
            }
            is Resource.Loading -> {
              locationDataState = locationDataState.copy(
                isLoading = result.isLoading
              )
            }
            //TODO: ADD ERROR SCREEN
            is Resource.Error -> Unit
          }
        }
    }
  }
}