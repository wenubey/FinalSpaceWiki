package com.github.wenubey.finalspacewiki.presentation.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.github.wenubey.finalspacewiki.R
import com.github.wenubey.finalspacewiki.presentation.ui.theme.cardBackGroundColor
import kotlin.random.Random

fun checkGender(gender: String): Int {
  return if (gender.contains("Male")) {
    R.drawable.ic_male
  } else if (gender.contains("Female")) {
    R.drawable.ic_female
  } else {
    R.drawable.ic_none_gender
  }
}

class Size {
  @Composable
  fun height(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp
  }

  @Composable
  fun width(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
  }
}

fun createCopyRightString(context: Context): AnnotatedString {
  return buildAnnotatedString {
    append(context.getString(R.string.copyright_first))
    pushStringAnnotation(tag = "TBS", annotation = "https://www.international.tbs.com")
    withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
      append(context.getString(R.string.tbs))
    }
    pop()
    append(context.getString(R.string.copyright_second))
    pushStringAnnotation(tag = "ADULT_SWIM", annotation = "https://www.adultswim.com")
    withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
      append(context.getString(R.string.adult_swim))
    }
    pop()
    append(context.getString(R.string.copyright_third))
    append(context.getString(R.string.copyright_fourth))
    pushStringAnnotation("FLAT_ICON", annotation = "https://www.flaticon.com")
    withStyle(style = SpanStyle(color = cardBackGroundColor, fontSize = 20.sp)) {
      append(context.getString(R.string.flat_icon))
    }
    pop()
    append(context.getString(R.string.copyright_fifth))
  }
}

fun List<String>.toIntList(): List<Int> {
  val list = mutableListOf<Int>()
  this.forEach { data ->
    list.add(
      data.substringAfterLast("/").toInt()
    )
  }
  return list
}

fun String.addCharAtIndex(char: Char, index: Int) =
  StringBuilder(this).apply { insert(index, char) }.toString()

fun String.addCommaExceptLast(listSize: Int, index: Int) =
  if (index == listSize - 1) {
    this
  } else {
    "$this, "
  }

// for after second space replace with new line
fun String.newLineAfterThirdWord(): String {
  val words = this.split(" ")
  return words.take(2).joinToString(" ") +
          "\n" +
          words.drop(2).joinToString(" ")
}



