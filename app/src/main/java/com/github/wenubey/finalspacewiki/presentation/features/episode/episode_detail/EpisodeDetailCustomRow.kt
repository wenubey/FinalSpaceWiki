package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun EpisodeDetailCustomRow(
  id: Int,
  text: String
) {
  Row(
    modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
    horizontalArrangement = Arrangement.Start
  ) {
    Icon(
      painter = painterResource(
        id = id
      ),
      contentDescription = "",
      tint = Color.White,
      modifier = Modifier.padding(top = 4.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = text, style = MaterialTheme.typography.h2)
  }
}