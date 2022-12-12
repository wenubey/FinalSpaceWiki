package com.github.wenubey.finalspacewiki.data.mapper

import com.github.wenubey.finalspacewiki.data.local.CharacterDataEntity
import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto
import com.github.wenubey.finalspacewiki.domain.model.CharacterData

fun CharacterDataDto.toCharacterData(): CharacterData {
    return CharacterData(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        hair = hair,
        alias = alias,
        origin = origin,
        abilities = abilities,
        img_url = img_url
    )
}

fun CharacterDataDto.toCharacterDataEntity(): CharacterDataEntity {
    return CharacterDataEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        hair = hair,
        alias = alias,
        origin = origin,
        abilities = abilities,
        img_url = img_url,
    )
}

fun CharacterDataEntity.toCharacterData(): CharacterData {
    return CharacterData(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        hair = hair,
        alias = alias,
        origin = origin,
        abilities = abilities,
        img_url = img_url,
    )
}