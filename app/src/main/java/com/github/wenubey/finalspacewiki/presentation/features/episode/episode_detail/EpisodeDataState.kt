package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail

import com.github.wenubey.finalspacewiki.domain.model.EpisodeData

data class EpisodeDataState(
  val data: EpisodeData? = null,
  val isLoading: Boolean = false,
  val error: String? = null,
)