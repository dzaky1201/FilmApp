package com.dzakyhdr.filmapp.domain.repository

import com.dzakyhdr.filmapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}