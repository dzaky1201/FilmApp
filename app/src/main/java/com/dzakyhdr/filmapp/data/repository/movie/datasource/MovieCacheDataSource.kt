package com.dzakyhdr.filmapp.data.repository.movie.datasource

import com.dzakyhdr.filmapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMovieFromDataCache(): List<Movie>
    suspend fun saveMovieToDataCache(movie: List<Movie>)
}