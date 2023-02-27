package com.github.wenubey.finalspacewiki.presentation.features.location.locationdetail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.domain.model.LocationData
import com.github.wenubey.finalspacewiki.presentation.features.character.CharacterViewModel
import com.github.wenubey.finalspacewiki.presentation.features.character.characterlist.CharacterListCard
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
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
  characterViewModel: CharacterViewModel,
) {

  GlobalScope.launch {
    characterViewModel.loadCharactersListForLocation(idList = data.notable_residents.toIntList())
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
      horizontalAlignment = CenterHorizontally
    ) {
      Text(text = data.name, style = MaterialTheme.typography.h1)
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = data.type, style = MaterialTheme.typography.h2)
      Spacer(modifier = Modifier.height(4.dp))
      GlideImage(
        model = data.img_url,
        contentDescription = data.name,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
          .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
          .clip(RoundedCornerShape(16.dp))
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = "Inhabitants", style = MaterialTheme.typography.h2)
      Spacer(modifier = Modifier.height(4.dp))
      LazyColumn(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalAlignment = CenterHorizontally,
        content = {
          items(data.inhabitants.size) { index ->
            Text(text = data.inhabitants[index], style = MaterialTheme.typography.body1)
          }
        }
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = "Notable Residents", style = MaterialTheme.typography.h2)
      Spacer(modifier = Modifier.height(4.dp))
      LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {
        characterViewModel.characterListForOtherScreenDataState.data?.let { characters ->
          items(characters.size) {index ->
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


