package com.dzakyhdr.filmapp.presentation.di.core

import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieCacheDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}