package com.github.wenubey.finalspacewiki.data.repository


import com.github.wenubey.finalspacewiki.data.local.WikiDatabase
import com.github.wenubey.finalspacewiki.data.mapper.*
import com.github.wenubey.finalspacewiki.data.remote.WikiApi
import com.github.wenubey.finalspacewiki.domain.model.CharacterData
import com.github.wenubey.finalspacewiki.domain.model.EpisodeData
import com.github.wenubey.finalspacewiki.domain.model.LocationData
import com.github.wenubey.finalspacewiki.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WikiRepository @Inject constructor(
  private val api: WikiApi,
  private val db: WikiDatabase,
) {

  private val dao = db.wikiDao
  suspend fun getCharactersData(
    fetchFromRemote: Boolean
  ): Flow<Resource<List<CharacterData>>> {
    return flow {
      emit(Resource.Loading(true))
      val localCharactersData = dao.getCharactersData()
      emit(Resource.Success(
        data = localCharactersData.map { it.toCharacterData() }
      ))
      val isDbEmpty = localCharactersData.isEmpty()
      val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
      if (shouldJustLoadFromCache) {
        emit(Resource.Loading(false))
        return@flow
      }
      val remoteCharactersData = try {
        api.getAllCharacters()
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }
      remoteCharactersData?.let { data ->
        dao.clearCharactersData()
        dao.insertCharactersData(
          data.map { it.toCharacterDataEntity() }
        )
        emit(Resource.Success(
          data = dao
            .getCharactersData()
            .map { it.toCharacterData() }
        ))
        emit(Resource.Loading(false))
      }
    }
  }

  suspend fun getCharacterData(
    id: Int,
    fetchFromRemote: Boolean = false,
  ): Flow<Resource<CharacterData>> {
    return flow {
      emit(Resource.Loading(true))
      val localCharacterData = dao.getCharacterFromLocal(id)
      emit(
        Resource.Success(
          data = localCharacterData.toCharacterData()
        )
      )
      if (!fetchFromRemote) {
        emit(Resource.Loading(false))
        return@flow
      }

      val remoteCharacterData = try {
        api.getCharacter(id)
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }
      remoteCharacterData?.let { character ->
        dao.clearCharacter(id)
        dao.insertCharacter(character.toCharacterDataEntity())
        emit(
          Resource.Success(
            data = dao.getCharacterFromLocal(id).toCharacterData()
          )
        )
        emit(Resource.Loading(false))
      }
    }
  }

  suspend fun getLocationsData(
    fetchFromRemote: Boolean
  ): Flow<Resource<List<LocationData>>> {
    return flow {
      emit(Resource.Loading(true))
      val localLocationsData = dao.getLocationsData()
      emit(Resource.Success(
        data = localLocationsData.map { it.toLocationData() }
      ))
      val isDbEmpty = localLocationsData.isEmpty()
      val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
      if (shouldJustLoadFromCache) {
        emit(Resource.Loading(false))
        return@flow
      }

      val remoteLocationsData = try {
        api.getAllLocations()
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }

      remoteLocationsData?.let { data ->
        dao.clearLocationsData()
        dao.insertLocationsData(
          data.map { it.toLocationDataEntity() }
        )
        emit(Resource.Success(
          data = dao
            .getLocationsData()
            .map { it.toLocationData() }
        ))
        emit(Resource.Loading(false))
      }
    }
  }

  suspend fun getLocationData(
    id: Int,
    fetchFromRemote: Boolean = false,
  ): Flow<Resource<LocationData>> {
    return flow {
      emit(Resource.Loading(true))
      val localLocationData = dao.getLocationFromLocal(id)
      emit(
        Resource.Success(
          data = localLocationData.toLocationData()
        )
      )

      if (!fetchFromRemote) {
        emit(Resource.Loading(false))
        return@flow
      }

      val remoteLocationData = try {
        api.getLocation(id)
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }

      remoteLocationData?.let { location ->
        dao.clearLocation(id)
        dao.insertLocation(location.toLocationDataEntity())
        emit(
          Resource.Success(
            data = dao.getLocationFromLocal(id).toLocationData()
          )
        )
        emit(Resource.Loading(false))
      }
    }
  }

  suspend fun getEpisodeData(
    id: Int,
    fetchFromRemote: Boolean = false
  ): Flow<Resource<EpisodeData>> {
    return flow {
      emit(Resource.Loading(true))
      val localEpisodeData = dao.getEpisodeFromLocal(id)
      emit(
        Resource.Success(
          data = localEpisodeData.toEpisodeData()
        )
      )

      if (!fetchFromRemote) {
        emit(Resource.Loading(false))
        return@flow
      }

      val remoteEpisodeData = try {
        api.getEpisode(id)
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }

      remoteEpisodeData?.let { episode ->
        dao.clearEpisode(id)
        dao.insertEpisode(episode.toEpisodeDataEntity())
        emit(
          Resource.Success(
            data = dao.getEpisodeFromLocal(id).toEpisodeData()
          )
        )
        emit(Resource.Loading(false))
      }
    }
  }

  suspend fun getEpisodesData(
    fetchFromRemote: Boolean
  ): Flow<Resource<List<EpisodeData>>> {
    return flow {
      emit(Resource.Loading(true))
      val localEpisodesData = dao.getEpisodesData()
      emit(
        Resource.Success(
          data = localEpisodesData.map { it.toEpisodeData() }
        )
      )
      val isDbEmpty = localEpisodesData.isEmpty()
      val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
      if (shouldJustLoadFromCache) {
        emit(Resource.Loading(false))
        return@flow
      }

      val remoteEpisodesData = try {
        api.getAllEpisodes()
      } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error("An error occurred $e"))
        null
      }

      remoteEpisodesData?.let { data ->
        dao.clearEpisodesData()
        dao.insertEpisodesData(
          data.map { it.toEpisodeDataEntity() }
        )
        emit(Resource.Success(
          data = dao.getEpisodesData()
            .map { it.toEpisodeData() }
        ))
        emit(Resource.Loading(false))
      }
    }
  }

}