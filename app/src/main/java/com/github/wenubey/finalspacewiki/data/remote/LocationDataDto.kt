package com.github.wenubey.finalspacewiki.data.remote

import com.squareup.moshi.Json

data class LocationDataDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "img_url")
    val img_url: String,
    @field:Json(name = "inhabitants")
    val inhabitants: List<String>,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "notable_residents")
    val notable_residents: List<String>,
    @field:Json(name = "type")
    val type: String
)