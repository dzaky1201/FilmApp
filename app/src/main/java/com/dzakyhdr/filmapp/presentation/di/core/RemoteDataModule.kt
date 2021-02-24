package com.dzakyhdr.filmapp.presentation.di.core

import com.dzakyhdr.filmapp.data.api.TMDBService
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}