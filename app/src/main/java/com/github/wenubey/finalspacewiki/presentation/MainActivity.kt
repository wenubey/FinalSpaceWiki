package com.github.wenubey.finalspacewiki.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wenubey.finalspacewiki.presentation.ui.theme.FinalSpaceWikiTheme
import com.github.wenubey.finalspacewiki.presentation.wikidetail.WikiDetailScreen
import com.github.wenubey.finalspacewiki.presentation.wikilist.WikiListScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WikiViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadCharactersList()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.INTERNET,
            )
        )
        setContent {
            FinalSpaceWikiTheme {
                Navigation(viewModel.listDataState, viewModel)
            }
        }
    }
}


