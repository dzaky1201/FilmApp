package com.dzakyhdr.filmapp.data.repository.movie.datasource

import com.dzakyhdr.filmapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovie(): Response<MovieList>
}