package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.domain.model.LocationData
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.features.common.Screen
import com.github.wenubey.finalspacewiki.presentation.util.Size

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun LocationListCard(
  data: List<LocationData>,
  index: Int,
  modifier: Modifier = Modifier,
  navController: NavController,
) {
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  Card(
    modifier = modifier
      .padding(8.dp),
    backgroundColor = cardBackGroundColor,
    shape = RoundedCornerShape(20.dp),
    onClick = {
      navController.navigate(Screen.LocationDetailScreen.route + "/${data[index].id}")
      println(Screen.LocationDetailScreen.route + "/${data[index].id}")
    }
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      GlideImage(
        model = data[index].img_url,
        contentScale = ContentScale.FillBounds,
        contentDescription = data[index].name,
        modifier = Modifier
          .size(height = (screenHeight *0.23).dp, width = screenWidth.dp,)
          .clip(RoundedCornerShape(16.dp))
      )
      Text(text = data[index].name, overflow = TextOverflow.Ellipsis)

    }
  }
}