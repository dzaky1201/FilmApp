package com.dzakyhdr.filmapp.presentation.di.movie

import com.dzakyhdr.filmapp.presentation.artist.ArtistActivity
import com.dzakyhdr.filmapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}