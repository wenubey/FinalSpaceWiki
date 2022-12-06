@file:OptIn(ExperimentalGlideComposeApi::class)

package com.github.wenubey.finalspacewiki.presentation.wikidetail

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.WikiViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "SupportAnnotationUsage")
@Composable
fun WikiDetailScreen(
    viewModel: WikiViewModel,
    id: Int? = 0,
) {
    GlobalScope.launch {
        viewModel.loadCharacter(id!!)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor
    ) {
        viewModel.characterDataState.data?.let { data ->
            WikiDetailCard(data = data)
        }

    }
}









