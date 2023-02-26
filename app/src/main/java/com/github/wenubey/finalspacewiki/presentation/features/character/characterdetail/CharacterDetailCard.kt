package com.github.wenubey.finalspacewiki.presentation.features.character.characterdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.*


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterDetailCard(
    data: CharacterData,
) {
    val scrollState = rememberScrollState()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = cardBackGroundColor,
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = data.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Image(
                    painter = painterResource(id = checkGender(data.gender)),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 40.dp, height = 40.dp)
                        .padding(horizontal = 8.dp)
                )
            }
            Text(
                text = data.status,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                GlideImage(
                    model = data.img_url,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(width = 200.dp, height = 200.dp),
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.species),
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = data.species ?: stringResource(R.string.unknown),
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.body1.fontSize
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CharacterDetailRow(
                        hintText = stringResource(R.string.hair_color),
                        dataText = data.hair,
                        imageVector = R.drawable.ic_hair
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CharacterDetailRow(
                        hintText = stringResource(R.string.origin),
                        dataText = data.origin,
                        imageVector = R.drawable.ic_earth
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                CharacterDetailAliasAbilitiesRow(
                    imageVector = R.drawable.ic_brain,
                    list = data.abilities
                )
                Spacer(modifier = Modifier.height(8.dp))
                CharacterDetailAliasAbilitiesRow(imageVector = R.drawable.ic_id, list = data.alias)

            }
        }


    }
}