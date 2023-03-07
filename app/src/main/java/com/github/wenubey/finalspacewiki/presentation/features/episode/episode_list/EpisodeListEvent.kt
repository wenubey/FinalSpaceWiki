package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list

sealed class EpisodeListEvent {
  object Refresh: EpisodeListEvent()
  data class OnSearchQueryChange(val query: String): EpisodeListEvent()
}
