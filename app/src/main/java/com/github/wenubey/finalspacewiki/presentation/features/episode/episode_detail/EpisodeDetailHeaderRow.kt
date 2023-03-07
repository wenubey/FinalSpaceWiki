package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R

@Composable
fun EpisodeDetailHeaderRow(
  chapterName: String,
  airDate: String,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(PaddingValues(start = 8.dp, end = 8.dp)),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = chapterName, style = MaterialTheme.typography.h1)
    Row(
      modifier = Modifier,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        modifier = Modifier.padding(top = 4.dp),
        painter = painterResource(id = R.drawable.on_air_24),
        contentDescription = "on_air",
        tint = Color.White
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(text = airDate, style = MaterialTheme.typography.h2)
    }
  }
}