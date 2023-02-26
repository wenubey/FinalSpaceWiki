package com.github.wenubey.finalspacewiki.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeDataEntity(
  @PrimaryKey val uid: Int? = null,
  val id: Int,
  val name: String,
  val air_date: String,
  val director: String,
  val writer: String,
  val characters: List<String>,
  val img_url: String,
)
