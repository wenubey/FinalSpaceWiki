
package com.github.wenubey.finalspacewiki.presentation.features.character.character_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
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
    viewModel: CharacterViewModel = hiltViewModel(),
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
            WikiTopBar(openDialog = openDialog)
        }
    )
}









