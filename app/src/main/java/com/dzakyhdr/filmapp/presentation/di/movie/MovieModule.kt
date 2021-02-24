package com.dzakyhdr.filmapp.presentation.di.movie

import com.dzakyhdr.filmapp.domain.usecase.GetArtistUseCase
import com.dzakyhdr.filmapp.domain.usecase.GetMovieUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateArtistUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateMovieUseCase
import com.dzakyhdr.filmapp.presentation.artist.ArtistViewModelFactory
import com.dzakyhdr.filmapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}