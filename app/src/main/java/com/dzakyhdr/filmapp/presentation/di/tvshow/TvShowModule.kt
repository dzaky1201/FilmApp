package com.dzakyhdr.filmapp.presentation.di.tvshow

import com.dzakyhdr.filmapp.domain.usecase.GetArtistUseCase
import com.dzakyhdr.filmapp.domain.usecase.GetTvShowUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateArtistUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateTvShowUseCase
import com.dzakyhdr.filmapp.presentation.artist.ArtistViewModelFactory
import com.dzakyhdr.filmapp.presentation.tv.TvViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvViewModelFactory {
        return TvViewModelFactory(getTvShowUseCase,updateTvShowUseCase)
    }
}