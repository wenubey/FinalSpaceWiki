package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_list

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EpisodeListScreen(
  context: Context,
  navController: NavController,
  viewModel: EpisodeViewModel
) {
  val openDialog = remember { mutableStateOf(false) }

  Scaffold(
    backgroundColor = backGroundColor,
    topBar = {
      WikiTopBar(context = context, openDialog = openDialog)
    },
    content = {
      EpisodeList(
        navController = navController,
        viewModel = viewModel
      )
    },
    bottomBar = {
      WikiNavBar(navController = navController)
    },
  )
}