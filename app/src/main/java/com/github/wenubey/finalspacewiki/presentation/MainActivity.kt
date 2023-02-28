package com.github.wenubey.finalspacewiki.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.FinalSpaceWikiTheme
import com.github.wenubey.finalspacewiki.presentation.features.common.Navigation
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val characterViewModel: CharacterViewModel by viewModels()
  private val locationViewModel: LocationViewModel by viewModels()
  private val episodeViewModel: EpisodeViewModel by viewModels()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    characterViewModel.loadCharactersList()
    locationViewModel.loadLocationsList()
    episodeViewModel.loadEpisodesList()
    setContent {
      FinalSpaceWikiTheme {
        Navigation(
          characterListDataState = characterViewModel.characterListDataState,
          characterViewModel = characterViewModel,
          locationListDataState = locationViewModel.locationListDataState,
          locationViewModel = locationViewModel,
          episodeListDataState = episodeViewModel.episodeListDataState,
          episodeViewModel = episodeViewModel,
          context = applicationContext
        )

      }
    }
  }

//    fun Context.setAppLocale(language: String): Context {
//        val locale = Locale(language)
//        Locale.setDefault(locale)
//        val config = resources.configuration
//        config.setLocale(locale)
//        config.setLayoutDirection(locale)
//        return createConfigurationContext(config)
//    }
//
//
//    override fun attachBaseContext(newBase: Context?) {
//        if (newBase != null) {
//            super.attachBaseContext(ContextWrapper(newBase.setAppLocale("tr")))
//        }
//    }

}


