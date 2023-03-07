package com.github.wenubey.finalspacewiki.presentation.features.character.character_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CharacterDetailRow(
    hintText: String,
    dataText: String,
    imageVector: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageVector),
            contentDescription = null,
            modifier = Modifier.size(width = 20.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = hintText,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic
        )
    }
    Text(
        text = dataText,
        fontSize = MaterialTheme.typography.body1.fontSize
    )
}