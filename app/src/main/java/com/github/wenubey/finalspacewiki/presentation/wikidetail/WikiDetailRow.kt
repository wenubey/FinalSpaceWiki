package com.github.wenubey.finalspacewiki.presentation.wikidetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R

@Composable
fun WikiDetailRow(
   imageVector: Int,
   text: String,

) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageVector),
            contentDescription = null,
            modifier = Modifier
                .size(width = 20.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}