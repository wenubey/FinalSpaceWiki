package com.github.wenubey.finalspacewiki.presentation.features.common

import com.github.wenubey.finalspacewiki.R

sealed class WikiNavBarItem(val route: String, val icon: Int, val title: String) {

  object CharacterList: WikiNavBarItem("characterListScreen", R.drawable.baseline_person_24, "Characters")

  object LocationList: WikiNavBarItem("locationListScreen", R.drawable.planet_earth, "Locations")

  //object EpisodeList: WikiNavBarItem("episodeListScreen", R.drawable.chapter, "Episodes")
}
