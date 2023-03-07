package com.github.wenubey.finalspacewiki.presentation.features.location

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.features.location.location_detail.CharacterListForLocationDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.location_detail.LocationDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.location_list.LocationListDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.location_list.LocationListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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

  var characterListForLocationDataState by mutableStateOf(CharacterListForLocationDataState())
    private set

  var searchQuery = mutableStateOf("")
    private set

  private var searchJob: Job? = null

  init {
    loadLocationsList(true)
  }

  fun onEvent(event: LocationListEvent) {
    when (event) {
      is LocationListEvent.Refresh -> {
        loadLocationsList(true)
      }
      is LocationListEvent.OnSearchQueryChanged -> {
        searchQuery.value = event.query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
          delay(500L)
          repository.getLocationsData(true)
            .collect { result ->
              when (result) {
                is Resource.Success -> {
                  result.data?.let { locations ->
                    locationListDataState = locationListDataState.copy(
                      locations = locations.filter {
                        it.name.contains(event.query, ignoreCase = true)
                      }
                    )
                  }
                }
                is Resource.Error -> {
                  locationListDataState = locationListDataState.copy(
                    error = result.message
                  )
                }
                is Resource.Loading -> {
                  locationListDataState = locationListDataState.copy(
                    isLoading = result.isLoading
                  )
                }
              }
            }
        }
      }
    }
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

            is Resource.Error -> {
              locationListDataState = locationListDataState.copy(
                error = result.message
              )
            }
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
          when (result) {
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
            is Resource.Error -> {
              locationDataState = locationDataState.copy(
                error = result.message
              )
            }
          }
        }
    }
  }

  fun loadCharactersListForLocation(
    idList: List<Int>
  ) {
    viewModelScope.launch {
      val list = mutableListOf<CharacterData>()
      idList.forEach { id ->
        repository.getCharacterData(id = id)
          .collect { result ->
            when (result) {
              is Resource.Success -> {
                result.data?.let {
                  list.add(it)
                }
              }
              is Resource.Loading -> {
                characterListForLocationDataState = characterListForLocationDataState.copy(
                  isLoading = result.isLoading
                )
              }
              is Resource.Error -> {
                characterListForLocationDataState = characterListForLocationDataState.copy(
                  error = result.message
                )
              }
            }
          }
      }
      characterListForLocationDataState = characterListForLocationDataState.copy(
        data = list
      )
    }
  }
}