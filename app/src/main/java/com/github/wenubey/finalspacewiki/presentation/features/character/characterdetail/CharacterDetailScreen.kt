@file:OptIn(ExperimentalGlideComposeApi::class)

package com.github.wenubey.finalspacewiki.presentation.features.character.characterdetail

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "SupportAnnotationUsage", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    viewModel: CharacterViewModel,
    id: Int? = 0,
) {
    GlobalScope.launch {
        viewModel.loadCharacter(id!!)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor,
        content = { padding ->
            viewModel.characterDataState.data?.let { data ->
                CharacterDetailCard(data = data)
            }
        }
    )
}









