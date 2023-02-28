package com.github.wenubey.finalspacewiki.data.mapper

import com.github.wenubey.finalspacewiki.data.local.entities.EpisodeDataEntity
import com.github.wenubey.finalspacewiki.data.remote.EpisodeDataDto
import com.github.wenubey.finalspacewiki.domain.model.EpisodeData
import com.github.wenubey.finalspacewiki.presentation.util.addCharAtIndex

fun EpisodeDataDto.toEpisodeData(): EpisodeData {
  return EpisodeData(
    id = id,
    name = name,
    air_date = air_date,
    director = director,
    writer = writer,
    characters = characters,
    img_url = img_url
  )
}

fun EpisodeDataDto.toEpisodeDataEntity(): EpisodeDataEntity {
  return  EpisodeDataEntity(
    id = id,
    name = name,
    air_date = air_date,
    director = director,
    writer = writer,
    characters = characters,
    img_url = img_url
  )
}

fun EpisodeDataEntity.toEpisodeData(): EpisodeData {
  return EpisodeData(
    id = id,
    name = name,
    air_date = air_date,
    director = director,
    writer = writer,
    characters = characters,
    img_url = img_url.addCharAtIndex(index = 4, char = 's')
  )
}