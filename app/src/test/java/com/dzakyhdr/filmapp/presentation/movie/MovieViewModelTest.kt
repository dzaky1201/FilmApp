package com.dzakyhdr.filmapp.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dzakyhdr.filmapp.data.model.movie.Movie
import com.dzakyhdr.filmapp.data.repository.movie.FakeMovieRepository
import com.dzakyhdr.filmapp.domain.usecase.GetMovieUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateMovieUseCase
import com.dzakyhdr.filmapp.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest=Config.NONE)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMovieUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMovieUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
    }

    @Test
    fun getMoviesTest(){
        val movie = mutableListOf<Movie>()
        movie.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movie.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))
        movie.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))

        //getOrAwaitValue() to convert live data format to normal data format
        val currentList = viewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movie)

    }

    @Test
    fun updateMoviesTest(){
        val movie = mutableListOf<Movie>()
        movie.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))
        movie.add(Movie(5, "overview5", "posterPath5", "date5", "title5"))

        //convert live data format to normal data format
        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(movie)

    }
}