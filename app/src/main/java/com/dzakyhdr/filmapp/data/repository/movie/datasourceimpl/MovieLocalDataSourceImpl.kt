package com.dzakyhdr.filmapp.data.repository.movie.datasourceimpl

import com.dzakyhdr.filmapp.data.db.MovieDao
import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val dao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return dao.getMovies()
    }

    override suspend fun saveMovieToDB(movie: List<Movie>) {
        // berjalan di background thread jadinya pakai coroutines
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllMovies()
        }
    }
}