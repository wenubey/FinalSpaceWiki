package com.github.wenubey.finalspacewiki.presentation.wikilist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
fun WikiListScreen(
    state: ListDataState,
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = appBarColor
            ) {
                Text(text = "Final Space Wiki", modifier = Modifier.padding(8.dp))
            }
        }
    ) {
        WikiList(state = state, navController = navController)
    }
}