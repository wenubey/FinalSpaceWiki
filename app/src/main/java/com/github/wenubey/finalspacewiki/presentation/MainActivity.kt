package com.github.wenubey.finalspacewiki.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.wenubey.finalspacewiki.presentation.features.common.Navigation
import com.github.wenubey.finalspacewiki.presentation.ui.theme.FinalSpaceWikiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FinalSpaceWikiTheme {
        Navigation()
      }
    }
  }

}


