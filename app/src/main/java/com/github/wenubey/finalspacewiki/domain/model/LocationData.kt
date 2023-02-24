package com.github.wenubey.finalspacewiki.domain.model

data class LocationData(
  val id: Int,
  val name: String,
  val type: String,
  val inhabitants: List<String>,
  val notable_residents: List<String>,
  val img_url: String
)
