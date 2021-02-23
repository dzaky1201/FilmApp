package com.dzakyhdr.filmapp.domain.repository

import com.dzakyhdr.filmapp.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}