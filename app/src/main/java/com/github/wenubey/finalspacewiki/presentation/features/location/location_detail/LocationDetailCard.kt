package com.github.wenubey.finalspacewiki.presentation.features.location.location_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.domain.model.LocationData
import com.github.wenubey.finalspacewiki.presentation.features.character.character_list.CharacterListCard
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.Size
import com.github.wenubey.finalspacewiki.presentation.util.addCommaExceptLast
import com.github.wenubey.finalspacewiki.presentation.util.toIntList
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalGlideComposeApi::class, DelicateCoroutinesApi::class)
@Composable
fun LocationDetailCard(
  data: LocationData,
  navController: NavController,
  locationViewModel: LocationViewModel,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  GlobalScope.launch {
    locationViewModel.loadCharactersListForLocation(idList = data.notable_residents.toIntList())
  }
  Card(
    modifier = Modifier
      .fillMaxSize()
      .padding(8.dp),
    shape = RoundedCornerShape(16.dp),
    backgroundColor = cardBackGroundColor.copy(alpha = 0.6f),
    elevation = 0.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
      horizontalAlignment = CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      GlideImage(
        model = data.img_url,
        contentDescription = data.name,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
          .clip(RoundedCornerShape(16.dp))
      )
      Text(
        text = data.name,
        style = MaterialTheme.typography.h1,
        modifier = Modifier
          .align(Alignment.Start)
      )
      Text(
        text = data.type,
        style = MaterialTheme.typography.h2,
        modifier = Modifier
          .align(Alignment.Start)
          .padding(start = 4.dp)
      )
      Text(
        text = stringResource(R.string.inhabitants),
        style = MaterialTheme.typography.h1,
        modifier = Modifier.align(Alignment.Start)
      )
      LazyRow(
        modifier = Modifier
          .fillMaxWidth()
          .padding(start = 4.dp),
        content = {
          items(data.inhabitants.size) { index ->
            Text(
              text = data.inhabitants[index].addCommaExceptLast(data.inhabitants.size, index),
              style = MaterialTheme.typography.body1
            )
          }
        }
      )
      Spacer(modifier = Modifier.height(12.dp))
      Box(
        modifier = Modifier
          .clip(RoundedCornerShape(16.dp))
          .background(cardBackGroundColor.copy(alpha = 0.8f))
          .padding(8.dp)
          .size(width = screenWidth.dp, height = (screenHeight * 0.4).dp,),
        contentAlignment = Alignment.TopStart
      ) {
        Column(modifier = Modifier, verticalArrangement = Arrangement.Top) {
          Text(
            text = stringResource(R.string.notable_residents),
            style = MaterialTheme.typography.h2,
          )
          Spacer(modifier = Modifier.height(4.dp))
          LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
              locationViewModel.characterListForLocationDataState.data?.let { characters ->
                items(characters.size) { index ->
                  CharacterListCard(
                    data = characters[index],
                    navController = navController,
                    backgroundColor = appBarColor
                  )
                }
              }
            })

        }
      }

    }
  }
}


