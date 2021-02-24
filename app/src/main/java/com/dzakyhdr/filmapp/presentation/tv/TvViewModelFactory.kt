package com.dzakyhdr.filmapp.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzakyhdr.filmapp.domain.usecase.GetTvShowUseCase
import com.dzakyhdr.filmapp.domain.usecase.UpdateTvShowUseCase

class TvViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}