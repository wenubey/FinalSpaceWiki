package com.github.wenubey.finalspacewiki.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(
    entities = [CharacterDataEntity::class],
    version = 1,
)
@TypeConverters(Converters::class )
abstract class WikiDatabase: RoomDatabase() {
    abstract val dao: WikiDao
}