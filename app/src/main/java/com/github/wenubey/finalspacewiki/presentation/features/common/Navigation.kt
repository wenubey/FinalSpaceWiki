package com.github.wenubey.finalspacewiki.presentation.features.common

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.character.character_detail.CharacterDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.character.character_list.CharacterListDataState
import com.github.wenubey.finalspacewiki.presentation.features.character.character_list.CharacterListScreen
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail.EpisodeDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list.EpisodeListDataState
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list.EpisodeListScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.features.location.location_detail.LocationDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.location_list.LocationListDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.location_list.LocationListScreen

@Composable
fun Navigation(
  characterListDataState: CharacterListDataState,
  locationListDataState: LocationListDataState,
  episodeListDataState: EpisodeListDataState,
  characterViewModel: CharacterViewModel,
  locationViewModel: LocationViewModel,
  episodeViewModel: EpisodeViewModel,
  context: Context,
) {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = Screen.CharacterListScreen.route
  ) {
    composable(
      route = Screen.CharacterListScreen.route
    ) {
      CharacterListScreen(
        navController = navController,
        viewModel = characterViewModel,
        context = context
      )
    }
    composable(
      route = Screen.CharacterDetailScreen.route + "/{id-char}",
      arguments = listOf(
        navArgument("id-char") {
          type = NavType.IntType
          defaultValue = 0

        }
      )
    ) {
      CharacterDetailScreen(
        viewModel = characterViewModel,
        id = it.arguments?.getInt("id-char"),
        context = context,
      )
    }
    composable(
      route = Screen.LocationListScreen.route
    ) {
      LocationListScreen(
        context = context,
        navController = navController,
        viewModel = locationViewModel,
      )
    }
    composable(
      route = Screen.LocationDetailScreen.route + "/{id-location}",
      arguments = listOf(
        navArgument("id-location") {
          type = NavType.IntType
          defaultValue = 0
        }
      )
    ) {
      LocationDetailScreen(
        viewModel = locationViewModel,
        context = context,
        id = it.arguments?.getInt("id-location"),
        navController = navController,
      )
    }
    composable(
      route = Screen.EpisodeListScreen.route
    ) {
      EpisodeListScreen(
        context = context,
        navController = navController,
        viewModel = episodeViewModel,
      )
    }
    composable(
      route = Screen.EpisodeDetailScreen.route + "/{id-episode}",
      arguments = listOf(
        navArgument("id-episode") {
          type = NavType.IntType
          defaultValue = 0
        }
      )
    ) {
      EpisodeDetailScreen(
        viewModel = episodeViewModel,
        context = context,
        id = it.arguments?.getInt("id-episode"),
        navController = navController
      )
    }
  }
}