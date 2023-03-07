package com.github.wenubey.finalspacewiki.presentation.features.location.location_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiSearchBar
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.util.Size

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LocationList(
  navController: NavController,
  viewModel: LocationViewModel,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  val pullRefreshState = rememberPullRefreshState(
    refreshing = viewModel.locationListDataState.isRefreshing,
    onRefresh = { viewModel.onEvent(LocationListEvent.Refresh) }
  )
  viewModel.locationListDataState.locations?.let { data ->
    Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
      Column(
        modifier = Modifier
          .padding(8.dp)
          .size(width = screenWidth.dp, height = (screenHeight * 0.85).dp)
      ) {
        WikiSearchBar(
          value = viewModel.searchQuery.value,
          onValueChange = {
            viewModel.onEvent(LocationListEvent.OnSearchQueryChanged(it))
          }
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyVerticalGrid(
          modifier = Modifier.size(width = screenWidth.dp, height = (screenHeight * 1).dp),
          columns = GridCells.Fixed(1),
          content = {
            items(data.size) { index ->
              LocationListCard(
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
      PullRefreshIndicator(
        refreshing = viewModel.locationListDataState.isRefreshing,
        state = pullRefreshState,
        modifier = Modifier.align(Alignment.TopCenter),
        contentColor = appBarColor
      )
    }

  }
}