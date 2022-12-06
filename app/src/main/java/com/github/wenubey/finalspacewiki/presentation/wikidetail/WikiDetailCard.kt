package com.github.wenubey.finalspacewiki.presentation.wikidetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.*


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WikiDetailCard(
    data: CharacterDataDto,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = cardBackGroundColor,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            GlideImage(
                model = data.img_url,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(width = 200.dp, height = 200.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = data.name)
            Image(
                painter = painterResource(
                    id = checkDeadAlive(data.status)
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.species ?: "Unknown",
                    modifier = Modifier.width(130.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(painter = painterResource(id = checkGender(data.gender)), contentDescription = null, modifier = Modifier.size(width = 20.dp, height = 20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = data.gender)
                Spacer(modifier = Modifier.width(8.dp))
            }
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Image(painter = painterResource(id = R.drawable.ic_hair), contentDescription = null, modifier = Modifier.size(width = 20.dp, height = 20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = data.hair)
                Spacer(modifier = Modifier.width(8.dp))
                Image(painter = painterResource(id = R.drawable.ic_earth), contentDescription = null, modifier = Modifier.size(width = 20.dp, height = 20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = data.origin)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(verticalArrangement = Arrangement.Center) {
                WikiListAliasAbilitiesRow(imageVector = R.drawable.ic_brain, list = data.abilities)
                Spacer(modifier = Modifier.height(16.dp))
                WikiListAliasAbilitiesRow(imageVector = R.drawable.ic_id, list = data.alias)
            }

        }
    }
}