package com.github.wenubey.finalspacewiki.presentation.features.character.character_list

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
fun CharacterListScreen(
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
        CharacterList(
          navController = navController,
          viewModel = viewModel,
        )
    },
    bottomBar = {
      WikiNavBar(navController = navController)
    }
  )
}