package com.github.wenubey.finalspacewiki.presentation.features.episode.episodelist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiSearchBar
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import com.github.wenubey.finalspacewiki.presentation.features.location.locationlist.LocationListCard
import com.github.wenubey.finalspacewiki.presentation.util.Size

@Composable
fun EpisodeList(
  state: EpisodeListDataState,
  navController: NavController,
  viewModel: EpisodeViewModel,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  state.data?.let { data ->
    Column(
      modifier = Modifier
        .padding(8.dp)
        .size(width = screenWidth.dp, height = (screenHeight * 0.82).dp)
    ) {
      WikiSearchBar(value = viewModel.searchQuery.value, onValueChange = viewModel::onSearch)
      Spacer(modifier = Modifier.height(4.dp))
      LazyVerticalGrid(
        modifier = Modifier.size(width = screenWidth.dp, height = (screenHeight * 1).dp),
        columns = GridCells.Fixed(1),
        content = {
          items(data.size) { index ->
            EpisodeListCard(
              data = data,
              index = index,
              navController = navController,
              modifier = Modifier.size(
                width = screenWidth.dp,
                height = (screenHeight * 0.3).dp,
              )
            )
          }
        },
      )
    }
  }
}