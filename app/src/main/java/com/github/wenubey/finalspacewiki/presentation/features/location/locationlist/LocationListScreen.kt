package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiNavBar
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun LocationListScreen(
  context: Context,
  navController: NavController,
) {
  val openDialog = remember { mutableStateOf(false) }
  Scaffold(
    topBar = {
      WikiTopBar(context = context, openDialog = openDialog)
    },
    backgroundColor = backGroundColor,
    content = { padding ->

    },
    bottomBar = {
      WikiNavBar(navController = navController)
    }
    )
}