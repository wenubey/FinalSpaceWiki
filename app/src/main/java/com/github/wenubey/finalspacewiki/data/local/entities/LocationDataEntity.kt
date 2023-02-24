package com.github.wenubey.finalspacewiki.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationDataEntity(
  @PrimaryKey val uid: Int? = null,
  val id: Int,
  val name: String,
  val type: String,
  val inhabitants: List<String>,
  val notable_residents: List<String>,
  val img_url: String
)