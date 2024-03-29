package com.github.wenubey.finalspacewiki.data.remote


import com.github.wenubey.finalspacewiki.domain.model.EpisodeData
import retrofit2.http.GET
import retrofit2.http.Path

interface WikiApi {

    @GET("character")
    suspend fun getAllCharacters(): List<CharacterDataDto>

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int,
    ): CharacterDataDto

    @GET("location")
    suspend fun getAllLocations(): List<LocationDataDto>

    @GET("location/{id}")
    suspend fun getLocation(
        @Path("id") id: Int,
    ): LocationDataDto

    @GET("episode")
    suspend fun getAllEpisodes(): List<EpisodeDataDto>

    @GET("episode/{id}")
    suspend fun getEpisode(
        @Path("id") id: Int,
    ): EpisodeDataDto
}