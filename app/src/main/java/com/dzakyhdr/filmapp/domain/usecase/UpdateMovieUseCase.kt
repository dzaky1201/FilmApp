package com.dzakyhdr.filmapp.domain.usecase

import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}