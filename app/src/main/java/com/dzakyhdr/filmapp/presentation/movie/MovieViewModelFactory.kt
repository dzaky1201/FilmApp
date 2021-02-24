package com.dzakyhdr.filmapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzakyhdr.filmapp.domain.usecase.GetMovieUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
    }
}