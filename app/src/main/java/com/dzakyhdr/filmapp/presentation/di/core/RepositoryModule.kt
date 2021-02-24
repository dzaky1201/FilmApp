package com.dzakyhdr.filmapp.presentation.di.core

import com.dzakyhdr.filmapp.data.repository.artist.ArtistRepositoryImpl
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.dzakyhdr.filmapp.data.repository.movie.MovieRepositoryImpl
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieCacheDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieLocalDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.TvShowRepositoryImpl
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.dzakyhdr.filmapp.domain.repository.ArtistRepository
import com.dzakyhdr.filmapp.domain.repository.MovieRepository
import com.dzakyhdr.filmapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource
        )
    }
}