package com.github.wenubey.finalspacewiki.presentation.util

sealed class Screen(val route: String) {
    object WikiListScreen: Screen("wikiListScreen")
    object WikiDetailScreen: Screen("wikiDetailScreen")
}
