package com.github.wenubey.finalspacewiki.presentation.features.common

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import com.github.wenubey.finalspacewiki.presentation.util.CustomAlertDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WikiTopBar(
  context: Context,
  openDialog: MutableState<Boolean>
) {
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = stringResource(R.string.app_bar_title),
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.h1,
      )
    },
    modifier = Modifier
      .fillMaxWidth()
      .clip(AbsoluteRoundedCornerShape(topLeft = 0.dp, topRight = 0.dp, bottomLeft = 16.dp, bottomRight = 16.dp)),
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = appBarColor
    ),
    actions = {
      IconButton(onClick = {
        openDialog.value = true
      }) {
        Icon(
          painter = painterResource(id = R.drawable.baseline_help_24),
          contentDescription = "",
          modifier = Modifier.size(30.dp),
          tint = Color.White
        )
      }
      if (openDialog.value) {
        CustomAlertDialog(context = context, openDialog = openDialog)
      }
    }
  )

}