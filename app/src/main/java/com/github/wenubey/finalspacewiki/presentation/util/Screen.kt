package com.github.wenubey.finalspacewiki.presentation.util

sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("characterListScreen")
    object CharacterDetailScreen: Screen("characterDetailScreen")
    object LocationDetailScreen: Screen("locationDetailScreen")
    object LocationListScreen: Screen("locationListScreen")
}
