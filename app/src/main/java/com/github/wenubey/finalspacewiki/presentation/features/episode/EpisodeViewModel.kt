package com.github.wenubey.finalspacewiki.presentation.features.episode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail.CharacterListForEpisodeDataState
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail.EpisodeDataState
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list.EpisodeListDataState
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list.EpisodeListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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

  var characterListForEpisodeDataState by mutableStateOf(CharacterListForEpisodeDataState())
    private set

  var searchQuery = mutableStateOf("")
    private set

  private var searchJob: Job? = null

  init {
    loadEpisodesList(true)
  }

  fun onEvent(event: EpisodeListEvent) {
    when(event) {
      is EpisodeListEvent.Refresh -> {
        loadEpisodesList(true)
      }
      is EpisodeListEvent.OnSearchQueryChange -> {
        searchQuery.value = event.query
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
                        it.name.contains(event.query, ignoreCase = true)
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
      val list = mutableListOf<CharacterData>()
      idList.forEach { id ->
        repository.getCharacterData(id = id)
          .collect { result ->
            when(result) {
              is Resource.Success -> {
                result.data?.let {
                  list.add(it)
                }
              }
              is Resource.Loading -> {
                characterListForEpisodeDataState = characterListForEpisodeDataState.copy(
                  isLoading = result.isLoading
                )
              }
              is Resource.Error -> {
                characterListForEpisodeDataState = characterListForEpisodeDataState.copy(
                  error = result.message
                )
              }
            }
          }
      }
      characterListForEpisodeDataState = characterListForEpisodeDataState.copy(
        data = list
      )
    }
  }


}