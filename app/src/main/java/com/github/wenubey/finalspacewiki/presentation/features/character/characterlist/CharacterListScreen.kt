package com.github.wenubey.finalspacewiki.presentation.features.character.characterlist

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun CharacterListScreen(
  state: CharacterListDataState,
  navController: NavController,
  viewModel: CharacterViewModel,
  context: Context
) {
  val openDialog = remember { mutableStateOf(false) }
  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    backgroundColor = backGroundColor,
    topBar = {
      WikiTopBar(context = context, openDialog = openDialog)
    },
    content = {
      CharacterList(state = state, navController = navController, viewModel = viewModel)
    }
  )
}