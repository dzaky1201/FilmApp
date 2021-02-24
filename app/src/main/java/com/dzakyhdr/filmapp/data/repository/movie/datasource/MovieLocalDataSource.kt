package com.dzakyhdr.filmapp.data.repository.movie.datasource

import com.dzakyhdr.filmapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB(): List<Movie>
    suspend fun saveMovieToDB(movie: List<Movie>)
    suspend fun clearAll()
}