package com.github.wenubey.finalspacewiki.presentation.features.episode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.model.EpisodeData
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.features.episode.episodedetail.EpisodeDataState
import com.github.wenubey.finalspacewiki.presentation.features.episode.episodelist.EpisodeListDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail.CharacterListForOtherScreenDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
  private val repository: WikiRepository,
) : ViewModel() {

  var episodeDataState by mutableStateOf(EpisodeDataState())
    private set

  var episodeListDataState by mutableStateOf(EpisodeListDataState())
    private set

  var characterListForOtherScreenDataState by mutableStateOf(CharacterListForOtherScreenDataState())
    private set

  var searchQuery = mutableStateOf("")
    private set

  private var searchJob: Job? = null

  init {
    loadEpisodesList(true)
  }

  fun onSearch(query: String) {
    searchQuery.value = query
    searchJob?.cancel()
    searchJob = viewModelScope.launch {
      delay(500L)
      repository.getEpisodesData(true)
        .collect { result ->
          when (result) {
            is Resource.Success -> {
              result.data?.let { episodes ->
                episodeListDataState = episodeListDataState.copy(
                  data = episodes.filter {
                    it.name.contains(query, ignoreCase = true)
                  }
                )
              }
            }
            is Resource.Loading -> {
              episodeListDataState = episodeListDataState.copy(
                isLoading = result.isLoading
              )
            }
            is Resource.Error -> {
              episodeListDataState = episodeListDataState.copy(
                error = result.message
              )
            }
          }
        }
    }
  }

  fun loadEpisodesList(
    fetchFromRemote: Boolean = false
  ) {
    viewModelScope.launch {
      repository
        .getEpisodesData(fetchFromRemote = fetchFromRemote)
        .collect { result ->
          when (result) {
            is Resource.Success -> {
              result.data?.let { episodes ->
                episodeListDataState = episodeListDataState.copy(
                  data = episodes
                )
              }
            }
            is Resource.Loading -> {
              episodeListDataState = episodeListDataState.copy(
                isLoading = result.isLoading
              )
            }
            is Resource.Error -> {
              episodeListDataState = episodeListDataState.copy(
                error = result.message
              )
            }
          }
        }
    }
  }

  fun loadEpisode(
    id: Int,
    fetchFromRemote: Boolean = false
  ) {
    viewModelScope.launch {
      repository
        .getEpisodeData(id = id, fetchFromRemote = fetchFromRemote)
        .collect{ result ->
          when (result) {
            is Resource.Success -> {
              result.data?.let { data ->
                episodeDataState = episodeDataState.copy(
                  data = data
                )
              }
            }
            is Resource.Loading -> {
              episodeDataState = episodeDataState.copy(
                isLoading = result.isLoading
              )
            }
            is Resource.Error -> {
              episodeDataState = episodeDataState.copy(
                error = result.message
              )
            }
          }
        }
    }
  }

  fun loadCharactersListForEpisode(
    idList: List<Int>
  ) {
    viewModelScope.launch {
      val list = mutableListOf<EpisodeData>()
      idList.forEach { id ->
        repository.getEpisodeData(id = id)
          .collect { result ->
            when(result) {
              is Resource.Success -> {
                result.data?.let {
                  list.add(it)
                }
              }
              is Resource.Loading -> {
                characterListForOtherScreenDataState = characterListForOtherScreenDataState.copy(
                  isLoading = result.isLoading
                )
              }
              is Resource.Error -> {

              }
            }
          }
      }
    }
  }


}