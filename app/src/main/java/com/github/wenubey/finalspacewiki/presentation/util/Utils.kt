package com.github.wenubey.finalspacewiki.presentation.util

import com.github.wenubey.finalspacewiki.R

fun checkDeadAlive(deadAlive: String): Int {
    return if (deadAlive.contains("Alive")) {
        R.drawable.ic_heartbeat
    } else if (deadAlive.contains("Unknown")) {
        R.drawable.ic_none_gender
    } else {
        R.drawable.ic_dead
    }
}

fun checkGender(gender: String): Int {
    return if (gender.contains("Male")) {
        R.drawable.ic_male
    } else if (gender.contains("Female")) {
        R.drawable.ic_female
    } else {
        R.drawable.ic_none_gender
    }
}