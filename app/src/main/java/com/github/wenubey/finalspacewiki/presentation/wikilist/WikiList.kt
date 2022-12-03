package com.github.wenubey.finalspacewiki.presentation.wikilist

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.wenubey.finalspacewiki.presentation.ListDataState

@Composable
fun WikiList(
    state: ListDataState,
    navController: NavController,
) {
    state.data?.let { data ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
                items(data.size) { index ->
                    WikiListCard(data = data, index = index, navController = navController)
                }
            }
        )
    }
}