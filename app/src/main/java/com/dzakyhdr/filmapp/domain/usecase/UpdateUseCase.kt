package com.dzakyhdr.filmapp.domain.usecase

import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.domain.repository.TvShowRepository

class UpdateUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShow()
}