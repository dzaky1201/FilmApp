package com.dzakyhdr.filmapp.data.repository.tvshow.datasource


import com.dzakyhdr.filmapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}