package com.dzakyhdr.filmapp.domain.usecase

import com.dzakyhdr.filmapp.data.model.artist.Artist
import com.dzakyhdr.filmapp.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}