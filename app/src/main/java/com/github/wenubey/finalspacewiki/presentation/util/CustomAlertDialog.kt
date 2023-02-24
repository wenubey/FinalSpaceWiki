package com.github.wenubey.finalspacewiki.presentation.util

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
fun CustomAlertDialog(
  context: Context,
  openDialog: MutableState<Boolean>
) {
  val uriHandler = LocalUriHandler.current
  AlertDialog(
    modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
    onDismissRequest = { openDialog.value = false },
    title = {
      Text(
        text = stringResource(R.string.how_to_use),
        style = MaterialTheme.typography.h1
      )
    },
    text = {
      Column {
        Text(
          text = stringResource(R.string.app_purpose),
          style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = stringResource(R.string.copyright),
          style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(8.dp))
        ClickableText(
          text = createCopyRightString(context),
          onClick = {offset ->
            createCopyRightString(context)
              .getStringAnnotations("TBS", offset, offset)
              .firstOrNull()?.let { link ->
                uriHandler.openUri(link.item)
              }
            createCopyRightString(context)
              .getStringAnnotations("ADULT_SWIM", offset, offset)
              .firstOrNull()?.let { link ->
                uriHandler.openUri(link.item)
              }
          },
          style = MaterialTheme.typography.body1
        )
      }

    },
    confirmButton = {},
    backgroundColor = backGroundColor
  )
}