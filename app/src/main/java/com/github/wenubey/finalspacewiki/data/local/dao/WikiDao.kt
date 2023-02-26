package com.github.wenubey.finalspacewiki.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.wenubey.finalspacewiki.data.local.entities.CharacterDataEntity
import com.github.wenubey.finalspacewiki.data.local.entities.EpisodeDataEntity
import com.github.wenubey.finalspacewiki.data.local.entities.LocationDataEntity

@Dao
interface WikiDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertCharactersData(
    characterDataEntities: List<CharacterDataEntity>
  )

  @Query("DELETE FROM characters")
  suspend fun clearCharactersData()

  @Query("SELECT * FROM characters ORDER BY id ASC")
  suspend fun getCharactersData(): List<CharacterDataEntity>

  @Query("SELECT * FROM characters WHERE id = :id")
  suspend fun getCharacterFromLocal(id: Int): CharacterDataEntity

  @Query("DELETE FROM characters WHERE id = :id")
  suspend fun clearCharacter(id: Int)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertCharacter(
    characterDataEntity: CharacterDataEntity
  )

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertLocationsData(
    locationDataEntities: List<LocationDataEntity>
  )

  @Query("DELETE FROM locations")
  suspend fun clearLocationsData()

  @Query("SELECT * FROM locations ORDER BY id ASC")
  suspend fun getLocationsData(): List<LocationDataEntity>

  @Query("SELECT * FROM locations WHERE id = :id")
  suspend fun getLocationFromLocal(id: Int): LocationDataEntity

  @Query("DELETE FROM locations WHERE id = :id")
  suspend fun clearLocation(id: Int)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertLocation(
    locationDataEntity: LocationDataEntity
  )

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertEpisodesData(
    episodeDataEntities: List<EpisodeDataEntity>
  )

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertEpisode(
    episodeDataEntity: EpisodeDataEntity
  )

  @Query("DELETE FROM episodes")
  suspend fun clearEpisodesData()

  @Query("DELETE FROM episodes WHERE id = :id")
  suspend fun clearEpisode(id: Int)

  @Query("SELECT * FROM episodes ORDER BY id ASC")
  suspend fun getEpisodesData(): List<EpisodeDataEntity>

  @Query("SELECT * FROM episodes WHERE id = :id")
  suspend fun getEpisodeFromLocal(id: Int): EpisodeDataEntity
}

