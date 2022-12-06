package com.github.wenubey.finalspacewiki.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.github.wenubey.finalspacewiki.presentation.ui.theme.FinalSpaceWikiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WikiViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharactersList()
        setContent {
            FinalSpaceWikiTheme {
                Navigation(viewModel.listDataState, viewModel)
            }
        }
    }
}


