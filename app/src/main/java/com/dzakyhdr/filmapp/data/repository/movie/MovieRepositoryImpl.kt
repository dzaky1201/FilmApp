package com.dzakyhdr.filmapp.data.repository.movie

import android.util.Log
import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieCacheDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieLocalDataSource
import com.dzakyhdr.filmapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.dzakyhdr.filmapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
       return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovie)
        movieCacheDataSource.saveMovieToDataCache(newListOfMovie)
        return newListOfMovie
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovie()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return movieList
    }

    private suspend fun getMovieFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMovieFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMovieFromDataCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMovieFromDB()
            movieCacheDataSource.saveMovieToDataCache(movieList)
        }
        return movieList
    }

}