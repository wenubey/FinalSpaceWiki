package com.github.wenubey.finalspacewiki.presentation.wikidetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R

@Composable
fun WikiDetailAliasAbilitiesRow(
    imageVector: Int,
    list: List<String>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageVector),
            contentDescription = null,
            modifier = Modifier
                .size(width = 20.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height((list.size * 21.7).dp),
            content = {
                items(list.size) { index ->
                    Text(text = list[index])
                }
            }
        )
    }
}