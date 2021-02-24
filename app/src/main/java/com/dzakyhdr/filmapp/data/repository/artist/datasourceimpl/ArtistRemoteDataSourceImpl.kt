package com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl

import com.dzakyhdr.filmapp.data.api.TMDBService
import com.dzakyhdr.filmapp.data.model.artist.ArtistList
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val service: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return service.getPopularArtists(apiKey)
    }
}