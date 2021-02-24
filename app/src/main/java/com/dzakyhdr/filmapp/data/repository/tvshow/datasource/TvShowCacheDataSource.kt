package com.dzakyhdr.filmapp.data.repository.tvshow.datasource

import com.dzakyhdr.filmapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}