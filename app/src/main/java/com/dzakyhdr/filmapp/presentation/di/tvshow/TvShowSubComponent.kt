package com.dzakyhdr.filmapp.presentation.di.tvshow

import com.dzakyhdr.filmapp.presentation.artist.ArtistActivity
import com.dzakyhdr.filmapp.presentation.tv.TvActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}