package com.dzakyhdr.filmapp.presentation.di.core

import com.dzakyhdr.filmapp.data.db.ArtistDao
import com.dzakyhdr.filmapp.data.db.MovieDao
import com.dzakyhdr.filmapp.data.db.TvShowDao
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieLocalDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(movieDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(movieDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(movieDao)
    }
}