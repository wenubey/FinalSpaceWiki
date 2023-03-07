package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list

import com.github.wenubey.finalspacewiki.domain.model.EpisodeData

data class EpisodeListDataState(
  val data: List<EpisodeData>? = null,
  val isLoading: Boolean = false,
  val isRefreshing: Boolean = false,
  val error: String? = null,
)
