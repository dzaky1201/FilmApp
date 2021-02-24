package com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl

import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}