package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.util.Size

@Composable
fun LocationList(
  state: LocationListDataState,
  navController: NavController,
  viewModel: LocationViewModel,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  state.locations.let { data ->
    Column(
      modifier =Modifier
        .padding(8.dp)
        .size(width = screenWidth.dp, height = (screenHeight * 0.87).dp)
    ) {
      LocationListSearchBar(viewModel = viewModel)
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
  }
}