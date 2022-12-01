package com.github.wenubey.finalspacewiki.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable



@Composable
fun FinalSpaceWikiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}