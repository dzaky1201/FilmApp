package com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl

import com.dzakyhdr.filmapp.data.api.TMDBService
import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.data.model.tvshow.TvShowList
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val service: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return service.getPopularTvShows(apiKey)
    }
}