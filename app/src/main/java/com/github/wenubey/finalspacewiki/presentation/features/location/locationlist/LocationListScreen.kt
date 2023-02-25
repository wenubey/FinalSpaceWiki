package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.Size

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun LocationListScreen(
  context: Context,
  state: LocationListDataState,
  navController: NavController,
  viewModel: LocationViewModel
) {
  val openDialog = remember { mutableStateOf(false) }
  Scaffold(
    topBar = {
      WikiTopBar(context = context, openDialog = openDialog)
    },
    backgroundColor = backGroundColor,
    content = {
      LocationList(
        state = state,
        navController = navController,
        viewModel = viewModel,
      )
    },
    bottomBar = {
      WikiNavBar(navController = navController,)
    }
  )
}