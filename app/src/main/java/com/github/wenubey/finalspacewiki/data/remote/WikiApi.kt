package com.github.wenubey.finalspacewiki.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface WikiApi {

    @GET("character")
    suspend fun getAllCharacters(): List<CharacterDataDto>

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int,
    ): CharacterDataDto
}