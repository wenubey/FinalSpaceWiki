@file:OptIn(DelicateCoroutinesApi::class)

package com.github.wenubey.finalspacewiki.presentation.features.episode.episodedetail

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun EpisodeDetailScreen(
  viewModel: EpisodeViewModel,
  context: Context,
  id: Int? = 0,
  navController: NavController
) {
  GlobalScope.launch {
    viewModel.loadEpisode(id!!)
  }
  val openDialog = remember { mutableStateOf(false) }
  Scaffold(
    backgroundColor = backGroundColor,
    topBar = {
      WikiTopBar(context = context, openDialog = openDialog)
    },
    content = {
      viewModel.episodeDataState.data?.let { data ->
        EpisodeDetailCard(
          data = data,
          navController = navController,
          episodeViewModel = viewModel
        )
      }
    },

  )
}