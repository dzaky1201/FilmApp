package com.dzakyhdr.filmapp.presentation.di.artist

import com.dzakyhdr.filmapp.domain.usecase.GetArtistUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateArtistUseCase
import com.dzakyhdr.filmapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}