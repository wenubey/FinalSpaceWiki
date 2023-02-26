package com.github.wenubey.finalspacewiki.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.wenubey.finalspacewiki.data.local.dao.WikiDao
import com.github.wenubey.finalspacewiki.data.local.entities.CharacterDataEntity
import com.github.wenubey.finalspacewiki.data.local.entities.EpisodeDataEntity
import com.github.wenubey.finalspacewiki.data.local.entities.LocationDataEntity

@Database(
    entities = [CharacterDataEntity::class, LocationDataEntity::class, EpisodeDataEntity::class],
    version = 1,
)
@TypeConverters(Converters::class )
abstract class WikiDatabase: RoomDatabase() {
    abstract val wikiDao: WikiDao
}