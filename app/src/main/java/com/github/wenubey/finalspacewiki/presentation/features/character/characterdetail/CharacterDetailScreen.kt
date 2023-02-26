@file:OptIn(ExperimentalGlideComposeApi::class)

package com.github.wenubey.finalspacewiki.presentation.features.character.characterdetail

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "SupportAnnotationUsage", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    viewModel: CharacterViewModel,
    context: Context,
    id: Int? = 0,
) {
    GlobalScope.launch {
        viewModel.loadCharacter(id!!)
    }
    val openDialog = remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor,
        content = {
            viewModel.characterDataState.data?.let { data ->
                CharacterDetailCard(data = data)
            }
        },
        topBar = {
            WikiTopBar(context = context, openDialog = openDialog)
        }
    )
}









