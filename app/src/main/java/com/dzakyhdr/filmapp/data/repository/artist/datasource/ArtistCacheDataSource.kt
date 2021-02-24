package com.dzakyhdr.filmapp.data.repository.artist.datasource

import com.dzakyhdr.filmapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromDataCache(): List<Artist>
    suspend fun saveArtistToDataCache(artist: List<Artist>)
}