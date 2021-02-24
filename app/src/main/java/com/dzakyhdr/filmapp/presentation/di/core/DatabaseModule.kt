package com.dzakyhdr.filmapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.dzakyhdr.filmapp.data.db.ArtistDao
import com.dzakyhdr.filmapp.data.db.MovieDao
import com.dzakyhdr.filmapp.data.db.TMDBDatabase
import com.dzakyhdr.filmapp.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb_client")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowDao()
    }
}