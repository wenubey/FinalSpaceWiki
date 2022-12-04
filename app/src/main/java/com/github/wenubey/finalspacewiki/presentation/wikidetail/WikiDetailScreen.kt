@file:OptIn(ExperimentalGlideComposeApi::class)

package com.github.wenubey.finalspacewiki.presentation.wikidetail

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.WikiViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "SupportAnnotationUsage")
@Composable
fun WikiDetailScreen(
    viewModel: WikiViewModel,
    id :Int? = 0,
) {
    GlobalScope.launch {
        viewModel.loadCharacter(id!!)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor
    ) {

        viewModel.characterDataState.data?.let { data ->

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = cardBackGroundColor,
            ) {
                Column(modifier = Modifier
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
                    Text(text = data.species)
                    Spacer(modifier = Modifier.height(8.dp))
                    WikiDetailRow(imageVector = checkGender(data.gender), text = data.gender)
                    Spacer(modifier = Modifier.height(8.dp))
                    WikiDetailRow(imageVector = R.drawable.ic_hair, text = data.hair)
                    Spacer(modifier = Modifier.height(8.dp))
                    WikiDetailRow(imageVector = R.drawable.ic_earth, text = data.origin)
                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }

    }
}

fun checkDeadAlive(deadAlive: String): Int {
    return if(deadAlive.contains("Alive")) {
        R.drawable.ic_heartbeat
    } else if(deadAlive.contains("Unknown")) {
        R.drawable.ic_none_gender
    } else {
        R.drawable.ic_dead
    }
}
fun checkGender(gender: String): Int {
    return if(gender.contains("Male")) {
        R.drawable.ic_male
    } else if(gender.contains("Female")) {
        R.drawable.ic_female
    } else {
        R.drawable.ic_none_gender
    }
}