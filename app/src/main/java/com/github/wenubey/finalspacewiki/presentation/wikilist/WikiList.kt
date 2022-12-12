package com.github.wenubey.finalspacewiki.presentation.wikilist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun WikiList(
    state: ListDataState,
    navController: NavController,
) {
    state.characters.let { data ->
        Column(modifier = Modifier.fillMaxSize()) {
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
}

