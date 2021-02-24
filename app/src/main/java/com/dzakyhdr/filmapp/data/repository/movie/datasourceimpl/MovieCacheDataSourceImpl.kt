package com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl

import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromDataCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToDataCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}