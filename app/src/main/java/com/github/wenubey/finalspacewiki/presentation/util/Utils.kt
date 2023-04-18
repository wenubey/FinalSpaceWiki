package com.github.wenubey.finalspacewiki.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.github.wenubey.finalspacewiki.R

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



