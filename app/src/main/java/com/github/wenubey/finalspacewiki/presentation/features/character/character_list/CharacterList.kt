package com.github.wenubey.finalspacewiki.presentation.features.character.character_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiSearchBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.util.Size

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterList(
  navController: NavController,
  viewModel: CharacterViewModel,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  val pullRefreshState = rememberPullRefreshState(
    refreshing = viewModel.characterListDataState.isRefreshing,
    onRefresh = {
      viewModel.onEvent(CharacterListEvent.Refresh)
    }
  )
  viewModel.characterListDataState.characters.let { data ->
    Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
      Column(
        modifier = Modifier
          .padding(8.dp)
          .size(width = screenWidth.dp, height = (screenHeight * 0.85).dp)
      ) {
        WikiSearchBar(
          value = viewModel.searchQuery.value,
          onValueChange = {
            viewModel.onEvent(CharacterListEvent.OnSearchQueryChange(it))
          }
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        LazyVerticalGrid(
          columns = GridCells.Fixed(3),
          content = {
            items(data.size) { index ->
              CharacterListCard(data = data[index], navController = navController)
            }
          }
        )
      }
      PullRefreshIndicator(
        refreshing = viewModel.characterListDataState.isRefreshing,
        state = pullRefreshState,
        modifier = Modifier.align(Alignment.TopCenter),
        contentColor = appBarColor
      )
    }
  }
}

