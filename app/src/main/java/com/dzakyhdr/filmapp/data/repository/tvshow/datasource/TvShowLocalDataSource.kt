package com.dzakyhdr.filmapp.data.repository.tvshow.datasource

import com.dzakyhdr.filmapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}