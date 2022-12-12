package com.github.wenubey.finalspacewiki.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.github.wenubey.finalspacewiki.domain.model.CharacterData

@Dao
interface WikiDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertCharactersData(
        characterDataEntities: List<CharacterDataEntity>
    )

    @Query("DELETE FROM characterdataentity")
    suspend fun clearCharactersData()

    @Query("SELECT * FROM characterdataentity ORDER BY id ASC")
    suspend fun getCharactersData(): List<CharacterDataEntity>

    @Query("SELECT * FROM characterdataentity WHERE id = :id")
    suspend fun getCharacterFromLocal(id: Int): CharacterDataEntity

    @Query("DELETE FROM characterdataentity WHERE id = :id")
    suspend fun clearCharacter(id: Int)

    @Insert(onConflict = REPLACE)
    suspend fun insertCharacter(
        characterDataEntity: CharacterDataEntity
    )
}