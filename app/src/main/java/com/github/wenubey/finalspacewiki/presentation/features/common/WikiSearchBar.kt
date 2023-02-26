package com.github.wenubey.finalspacewiki.presentation.features.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WikiSearchBar(
  value: String,
  onValueChange: (String) -> Unit,
) {
  TextField(
    modifier = Modifier
      .padding(4.dp)
      .fillMaxWidth()
      .clip(RoundedCornerShape(16.dp)),
    value = value,
    onValueChange = onValueChange,
    maxLines = 1,
    leadingIcon = {
      Icon(
        painter = painterResource(id = R.drawable.baseline_search_24),
        contentDescription = "",
        tint = Color.White
      )
    },
    placeholder = { Text(text = "Search location", style = MaterialTheme.typography.body1) },
    textStyle = MaterialTheme.typography.body1,
    colors = TextFieldDefaults.textFieldColors(
      containerColor = appBarColor.copy(alpha = 0.5f),
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      cursorColor = cardBackGroundColor,

    )
  )
}

