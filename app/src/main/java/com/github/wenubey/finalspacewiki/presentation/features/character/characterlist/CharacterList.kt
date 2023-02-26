package com.github.wenubey.finalspacewiki.presentation.features.character.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiSearchBar
import com.github.wenubey.finalspacewiki.presentation.util.Size

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterList(
    state: CharacterListDataState,
    navController: NavController,
    viewModel: CharacterViewModel,
) {
    val screenSize = Size()
    val screenHeight = screenSize.height()
    val screenWidth = screenSize.width()
    state.characters.let { data ->
        Column(
            modifier = Modifier
                .padding(8.dp)
                .size(width = screenWidth.dp, height = (screenHeight * 0.85).dp)
        ) {
            WikiSearchBar(value = viewModel.searchQuery.value, onValueChange = viewModel::onSearch)
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                content = {
                    items(data.size) { index ->
                        CharacterListCard(data = data[index],  navController = navController)
                    }
                }
            )
        }
    }
}

