package com.github.wenubey.finalspacewiki.presentation.wikidetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R

@Composable
fun WikiListAliasAbilitiesRow(
    imageVector: Int,
    list: List<String>
) {
    Row(
        modifier = Modifier
            .width(200.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageVector),
            contentDescription = null,
            modifier = Modifier
                .size(width = 20.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        LazyColumn(
            content = {
                items(list.size) { index ->
                    Text(text = list[index])

                }
            }
        )
    }
}