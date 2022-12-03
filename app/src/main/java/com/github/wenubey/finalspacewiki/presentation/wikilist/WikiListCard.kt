@file:OptIn(ExperimentalGlideComposeApi::class)

package com.github.wenubey.finalspacewiki.presentation.wikilist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto
import com.github.wenubey.finalspacewiki.presentation.Screen
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WikiListCard(
    data: List<CharacterDataDto>,
    index: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(width = 120.dp, height = 150.dp),
        backgroundColor = cardBackGroundColor,
        shape = RoundedCornerShape(20.dp),
        onClick = {
            navController.navigate(Screen.WikiDetailScreen.route + "/${data[index].id}")
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
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = data[index].name, overflow = TextOverflow.Ellipsis)
        }
    }
}