package com.dzakyhdr.filmapp.presentation.di.core

import com.dzakyhdr.filmapp.presentation.di.artist.ArtistSubComponent
import com.dzakyhdr.filmapp.presentation.di.movie.MovieSubComponent
import com.dzakyhdr.filmapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}