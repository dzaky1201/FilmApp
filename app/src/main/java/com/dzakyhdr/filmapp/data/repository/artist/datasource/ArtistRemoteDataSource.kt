package com.dzakyhdr.filmapp.data.repository.artist.datasource

import com.dzakyhdr.filmapp.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}