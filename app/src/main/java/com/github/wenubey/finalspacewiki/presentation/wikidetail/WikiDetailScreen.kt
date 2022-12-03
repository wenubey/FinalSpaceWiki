package com.github.wenubey.finalspacewiki.presentation.wikidetail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.github.wenubey.finalspacewiki.presentation.CharacterDataState
import com.github.wenubey.finalspacewiki.presentation.WikiViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import javax.inject.Inject

@Composable
fun WikiDetailScreen(
    viewModel: WikiViewModel,
    id :Int? = 0,
) {
    viewModel.loadCharacter(id!!)
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor
    ) {

        
        viewModel.characterDataState.data?.let { 
            Text(text = it.name)
        }

    }
}