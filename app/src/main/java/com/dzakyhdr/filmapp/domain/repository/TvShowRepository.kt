package com.dzakyhdr.filmapp.domain.repository

import com.dzakyhdr.filmapp.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShow(): List<TvShow>?
    suspend fun updateTvShow(): List<TvShow>?
}