package com.dzakyhdr.filmapp.presentation.di

import com.dzakyhdr.filmapp.presentation.di.artist.ArtistSubComponent
import com.dzakyhdr.filmapp.presentation.di.movie.MovieSubComponent
import com.dzakyhdr.filmapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}