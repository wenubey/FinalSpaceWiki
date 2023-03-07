package com.github.wenubey.finalspacewiki.presentation.features.episode.episode_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.domain.model.EpisodeData
import com.github.wenubey.finalspacewiki.presentation.features.character.character_list.CharacterListCard
import com.github.wenubey.finalspacewiki.presentation.features.episode.EpisodeViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.toIntList
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class, ExperimentalGlideComposeApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun EpisodeDetailCard(
  data: EpisodeData,
  navController: NavController,
  episodeViewModel: EpisodeViewModel
) {
  GlobalScope.launch {
    episodeViewModel.loadCharactersListForEpisode(idList = data.characters.toIntList())
  }
  Card(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    shape = RoundedCornerShape(16.dp),
    backgroundColor = cardBackGroundColor,
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      EpisodeDetailHeaderRow(chapterName = data.name, airDate = data.air_date)
      Spacer(modifier = Modifier.height(4.dp))
      EpisodeDetailCustomRow(
        text = data.director,
        id = com.github.wenubey.finalspacewiki.R.drawable.chair_director_icon
      )
      Spacer(modifier = Modifier.height(4.dp))
      EpisodeDetailCustomRow(
        text = data.writer,
        id = com.github.wenubey.finalspacewiki.R.drawable.pencil_outline_icon
      )
      GlideImage(
        model = data.img_url,
        contentDescription = data.name,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
          .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
          .clip(RoundedCornerShape(16.dp))
      )
      Spacer(modifier = Modifier.height(4.dp))
      LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {
          episodeViewModel.characterListForEpisodeDataState.data?.let { episodes ->
            items(episodes.size) { index ->
              CharacterListCard(
                data = episodes[index],
                navController = navController,
                backgroundColor = appBarColor,
              )
            }
          }
        },
      )
    }
  }
}