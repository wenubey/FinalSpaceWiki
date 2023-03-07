package com.github.wenubey.finalspacewiki.presentation.features.character.character_list

sealed class CharacterListEvent {
  object Refresh: CharacterListEvent()
  data class OnSearchQueryChange(val query: String): CharacterListEvent()
}