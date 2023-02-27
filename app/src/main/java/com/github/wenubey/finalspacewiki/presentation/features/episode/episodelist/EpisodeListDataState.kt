package com.github.wenubey.finalspacewiki.presentation.features.episode.episodelist

import com.github.wenubey.finalspacewiki.domain.model.EpisodeData

data class EpisodeListDataState(
  val data: List<EpisodeData>? = null,
  val isLoading: Boolean = false,
  val error: String? = null,
)
