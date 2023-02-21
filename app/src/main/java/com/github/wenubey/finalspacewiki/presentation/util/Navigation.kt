package com.github.wenubey.finalspacewiki.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.WikiViewModel
import com.github.wenubey.finalspacewiki.presentation.wikidetail.WikiDetailScreen
import com.github.wenubey.finalspacewiki.presentation.wikilist.ListDataState
import com.github.wenubey.finalspacewiki.presentation.wikilist.WikiListScreen

@Composable
fun Navigation(
    listDataState: ListDataState,
    viewModel: WikiViewModel,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.WikiListScreen.route
    ) {
        composable(
            route = Screen.WikiListScreen.route
        ) {
            WikiListScreen(state = listDataState, navController, viewModel = viewModel)
        }
        composable(
            route = Screen.WikiDetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0

                }
            )
        ) {
            WikiDetailScreen(
                viewModel = viewModel,
                id = it.arguments?.getInt("id"),
            )
        }
    }
}