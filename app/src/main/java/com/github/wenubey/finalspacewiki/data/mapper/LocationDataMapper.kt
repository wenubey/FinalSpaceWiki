package com.github.wenubey.finalspacewiki.data.mapper

import com.github.wenubey.finalspacewiki.data.local.entities.LocationDataEntity
import com.github.wenubey.finalspacewiki.data.remote.LocationDataDto
import com.github.wenubey.finalspacewiki.domain.model.LocationData

fun LocationDataDto.toLocationData(): LocationData {
  return LocationData(
    id = id,
    name = name,
    type = type,
    inhabitants = inhabitants,
    notable_residents = notable_residents,
    img_url = img_url,
  )
}

fun LocationDataDto.toLocationDataEntity(): LocationDataEntity {
  return LocationDataEntity(
    id = id,
    name = name,
    type = type,
    inhabitants = inhabitants,
    notable_residents = notable_residents,
    img_url = img_url
  )
}

fun LocationDataEntity.toLocationData(): LocationData {
  return LocationData(
    id = id,
    name = name,
    type = type,
    inhabitants = inhabitants,
    notable_residents = notable_residents,
    img_url = img_url
  )
}