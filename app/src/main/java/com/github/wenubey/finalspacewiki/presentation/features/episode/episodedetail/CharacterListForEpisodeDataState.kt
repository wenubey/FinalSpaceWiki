package com.github.wenubey.finalspacewiki.presentation.features.episode.episodedetail

import com.github.wenubey.finalspacewiki.domain.model.CharacterData

data class CharacterListForEpisodeDataState(
  val data: List<CharacterData>? = null,
  val isLoading: Boolean = false,
  val error: String? = null
)
