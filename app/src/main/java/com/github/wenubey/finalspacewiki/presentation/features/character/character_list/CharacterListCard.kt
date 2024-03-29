package com.github.wenubey.finalspacewiki.presentation.features.character.character_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.presentation.features.common.Screen
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.Size

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun CharacterListCard(
    data: CharacterData,
    modifier: Modifier = Modifier,
    navController: NavController,
    backgroundColor: Color = cardBackGroundColor,
    cardSizeWidth: Double = Size().width() * 0.2,
    cardSizeHeight: Double = Size().height() * 0.2
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(width = (cardSizeWidth).dp, height = (cardSizeHeight).dp),
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(20.dp),
        onClick = {
            navController.navigate(Screen.CharacterDetailScreen.route + "/${data.id}")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                model = data.img_url,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = data.name, overflow = TextOverflow.Ellipsis)
        }
    }
}



