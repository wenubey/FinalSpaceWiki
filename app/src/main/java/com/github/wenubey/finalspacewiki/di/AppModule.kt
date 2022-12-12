package com.github.wenubey.finalspacewiki.di


import android.app.Application
import androidx.room.Room
import com.github.wenubey.finalspacewiki.data.local.WikiDatabase
import com.github.wenubey.finalspacewiki.data.remote.WikiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWikiApi(): WikiApi {
        return Retrofit.Builder()
            .baseUrl("https://finalspaceapi.com/api/v0/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWikiDatabase(app: Application): WikiDatabase {
        return Room.databaseBuilder(
            app,
            WikiDatabase::class.java,
            "wiki.db"
        ).build()
    }




}