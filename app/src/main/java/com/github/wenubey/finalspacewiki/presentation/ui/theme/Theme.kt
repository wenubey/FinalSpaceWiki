package com.github.wenubey.finalspacewiki.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun FinalSpaceWikiTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = appBarColor
    )
    systemUiController.setSystemBarsColor(
        color = appBarColor
    )
    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}