package com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl

import com.dzakyhdr.filmapp.data.api.TMDBService
import com.dzakyhdr.filmapp.data.model.movie.MovieList
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val service: TMDBService,
    private val apiKey: String)
    : MovieRemoteDataSource {
    override suspend fun getMovie(): Response<MovieList> = service.getPopularMovies(apiKey)
}