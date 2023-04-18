package com.github.wenubey.finalspacewiki.presentation.features.common

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.features.character.character_detail.CharacterDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.character.character_list.CharacterListScreen
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail.EpisodeDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list.EpisodeListScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.location_detail.LocationDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.location_list.LocationListScreen

@Composable
fun Navigation(
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
        id = it.arguments?.getInt("id-char"),
      )
    }
    composable(
      route = Screen.LocationListScreen.route
    ) {
      LocationListScreen(
        navController = navController,
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
        id = it.arguments?.getInt("id-location"),
        navController = navController,
      )
    }
    composable(
      route = Screen.EpisodeListScreen.route
    ) {
      EpisodeListScreen(
        navController = navController,
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
        id = it.arguments?.getInt("id-episode"),
        navController = navController
      )
    }
  }
}