package com.dzakyhdr.filmapp.presentation

import android.app.Application
import com.dzakyhdr.filmapp.BuildConfig
import com.dzakyhdr.filmapp.presentation.di.Injector
import com.dzakyhdr.filmapp.presentation.di.artist.ArtistSubComponent
import com.dzakyhdr.filmapp.presentation.di.core.*
import com.dzakyhdr.filmapp.presentation.di.movie.MovieSubComponent
import com.dzakyhdr.filmapp.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
       return appComponent.artistSubComponent().create()
    }
}