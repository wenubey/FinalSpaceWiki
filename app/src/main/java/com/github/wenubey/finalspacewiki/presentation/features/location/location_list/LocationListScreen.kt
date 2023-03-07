package com.github.wenubey.finalspacewiki.presentation.features.location.location_list

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun LocationListScreen(
  context: Context,
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
        navController = navController,
        viewModel = viewModel,
      )
    },
    bottomBar = {
      WikiNavBar(navController = navController)
    }
  )
}