package com.github.wenubey.finalspacewiki.presentation.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.character.characterdetail.CharacterDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.character.characterlist.CharacterListDataState
import com.github.wenubey.finalspacewiki.presentation.features.character.characterlist.CharacterListScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail.LocationDetailScreen
import com.github.wenubey.finalspacewiki.presentation.features.location.locationlist.LocationListDataState
import com.github.wenubey.finalspacewiki.presentation.features.location.locationlist.LocationListScreen

@Composable
fun Navigation(
  characterListDataState: CharacterListDataState,
  locationListDataState: LocationListDataState,
  characterViewModel: CharacterViewModel,
  locationViewModel: LocationViewModel,
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
        state = characterListDataState,
        navController,
        viewModel = characterViewModel,
        context = context
      )
    }
    composable(
      route = Screen.CharacterDetailScreen.route + "/{id}",
      arguments = listOf(
        navArgument("id") {
          type = NavType.IntType
          defaultValue = 0

        }
      )
    ) {
      CharacterDetailScreen(
        viewModel = characterViewModel,
        id = it.arguments?.getInt("id"),
      )
    }
    composable(
      route = Screen.LocationListScreen.route
    ) {
      LocationListScreen(
        context = context,
        navController = navController,
        state = locationListDataState,
        viewModel = locationViewModel,
      )
    }
    composable(
      route = Screen.LocationDetailScreen.route + "/{id}",
      arguments = listOf(
        navArgument("id") {
          type = NavType.IntType
          defaultValue = 0
        }
      )
    ) {
      LocationDetailScreen(viewModel = locationViewModel, context = context)
    }
  }
}