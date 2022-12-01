package com.github.wenubey.finalspacewiki.data.repository

import com.github.wenubey.finalspacewiki.data.remote.CharacterDataDto
import com.github.wenubey.finalspacewiki.data.remote.CharactersDataDto
import com.github.wenubey.finalspacewiki.data.remote.WikiApi
import com.github.wenubey.finalspacewiki.domain.util.Resource
import javax.inject.Inject

class WikiRepository  @Inject constructor(
    private val api: WikiApi,
) {

    suspend fun getCharactersData(): Resource<CharactersDataDto> {
        return try {
            Resource.Success(
                data = api.getAllCharacters()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    suspend fun getCharacterData(id: Int): Resource<CharacterDataDto>{
        return try {
            Resource.Success(
                data = api.getCharacter(id)
            )
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occured")
        }
    }
}