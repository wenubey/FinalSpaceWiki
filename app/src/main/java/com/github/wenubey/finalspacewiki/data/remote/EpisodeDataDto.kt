package com.github.wenubey.finalspacewiki.data.remote

data class EpisodeDataDto(
    val id: Int,
    val name: String,
    val air_date: String,
    val director: String,
    val writer: String,
    val characters: List<String>,
    val img_url: String,
)