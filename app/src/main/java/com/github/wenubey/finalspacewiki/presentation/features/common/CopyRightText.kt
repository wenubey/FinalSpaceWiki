package com.github.wenubey.finalspacewiki.presentation.features.common

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor

@Composable
fun CopyrightText(uriHandler: UriHandler) {
    val annotatedString = buildAnnotatedString {
        append(stringResource(R.string.copyright_first))
        pushStringAnnotation(tag = "TBS", annotation = "https://www.international.tbs.com")
        withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
            append(stringResource(R.string.tbs))
        }
        pop()
        append(stringResource(R.string.copyright_second))
        pushStringAnnotation(tag = "ADULT_SWIM", annotation = "https://www.adultswim.com")
        withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
            append(stringResource(R.string.adult_swim))
        }
        pop()
        append(stringResource(R.string.copyright_third))
        append(stringResource(R.string.copyright_fourth))
        pushStringAnnotation("FLAT_ICON", annotation = "https://www.flaticon.com")
        withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
            append(stringResource(R.string.flat_icon))
        }
        pop()
        append(stringResource(R.string.copyright_fifth))
    }
    ClickableText(text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations("TBS", offset, offset)
                .firstOrNull()?.let { link ->
                    uriHandler.openUri(link.item)
                }
            annotatedString
                .getStringAnnotations("ADULT_SWIM", offset, offset)
                .firstOrNull()?.let { link ->
                    uriHandler.openUri(link.item)
                }
            annotatedString
                .getStringAnnotations("FLAT_ICON", offset, offset)
                .firstOrNull()?.let { link ->
                    uriHandler.openUri(link.item)
                }
        },
        style = MaterialTheme.typography.body1
    )
}