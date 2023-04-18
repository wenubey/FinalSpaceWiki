package com.github.wenubey.finalspacewiki.presentation.features.character.character_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor


@Composable
fun CharacterListScreen(
  navController: NavController,
  viewModel: CharacterViewModel = hiltViewModel(),
) {
  val openDialog = remember { mutableStateOf(false) }
  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    backgroundColor = backGroundColor,
    topBar = {
      WikiTopBar( openDialog = openDialog)
    },
    content = { paddingValues ->
        CharacterList(
          navController = navController,
          viewModel = viewModel,
          modifier = Modifier.padding(paddingValues)
        )
    },
    bottomBar = {
      WikiNavBar(navController = navController)
    }
  )
}