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
        Navigation(
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


