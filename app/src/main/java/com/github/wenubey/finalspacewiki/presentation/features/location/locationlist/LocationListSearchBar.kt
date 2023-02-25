package com.github.wenubey.finalspacewiki.presentation.features.location.locationlist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel

@Composable
fun LocationListSearchBar(
  viewModel: LocationViewModel
) {
  TextField(
    modifier = Modifier
      .padding(4.dp)
      .fillMaxWidth(),
    value = viewModel.searchQuery.value,
    onValueChange = viewModel::onSearch,
    maxLines = 1,
    leadingIcon = {
      Icon(
        painter = painterResource(id = R.drawable.baseline_search_24),
        contentDescription = "",
        tint = Color.White
      )
    },
    placeholder = { Text(text = "Search location", style = MaterialTheme.typography.body1)},
    textStyle = MaterialTheme.typography.body1

  )
}