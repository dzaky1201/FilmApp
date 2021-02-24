package com.dzakyhdr.filmapp.data.repository.artist.datasource

import com.dzakyhdr.filmapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}