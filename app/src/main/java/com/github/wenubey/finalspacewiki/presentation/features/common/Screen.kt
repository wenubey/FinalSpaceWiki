package com.github.wenubey.finalspacewiki.presentation.features.common

sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("characterListScreen")
    object CharacterDetailScreen: Screen("characterDetailScreen")
    object LocationDetailScreen: Screen("locationDetailScreen")
    object LocationListScreen: Screen("locationListScreen")
    object EpisodeListScreen: Screen("episodeListScreen")
    object EpisodeDetailScreen: Screen("episodeDetailScreen")
}
