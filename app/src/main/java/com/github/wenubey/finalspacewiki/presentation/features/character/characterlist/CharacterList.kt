package com.github.wenubey.finalspacewiki.presentation.features.character.characterlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterList(
    state: CharacterListDataState,
    navController: NavController,
    viewModel: CharacterViewModel
) {
    state.characters.let { data ->
        Column(modifier = Modifier.fillMaxSize()) {
            CharacterListSearchBar(viewModel = viewModel)
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                content = {
                    items(data.size) { index ->
                        CharacterListCard(data = data, index = index, navController = navController)
                    }
                }
            )
        }
    }
}

