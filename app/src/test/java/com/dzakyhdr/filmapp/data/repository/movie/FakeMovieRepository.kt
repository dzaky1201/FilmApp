package com.dzakyhdr.filmapp.data.repository.movie

import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movie = mutableListOf<Movie>()

    init {
        movie.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movie.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))
        movie.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movie
    }

    override suspend fun updateMovies(): List<Movie>? {
        movie.clear()
        movie.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))
        movie.add(Movie(5, "overview5", "posterPath5", "date5", "title5"))
        return movie
    }
}