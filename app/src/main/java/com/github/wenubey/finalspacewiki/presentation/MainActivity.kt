package com.github.wenubey.finalspacewiki.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.presentation.ui.theme.FinalSpaceWikiTheme
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WikiViewModel by viewModels()

    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharacter(1)
        setContent {
            FinalSpaceWikiTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    viewModel.characterDataState.data?.let { data ->
                        Card(
                            backgroundColor = cardBackGroundColor,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            GlideImage(model = data.img_url, contentDescription = null)
                            Text(text = data.name )
                        }
                    }
                }
            }
        }
    }
}

