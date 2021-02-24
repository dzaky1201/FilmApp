package com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl

import com.dzakyhdr.filmapp.data.db.ArtistDao
import com.dzakyhdr.filmapp.data.model.artist.Artist
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val dao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return dao.getArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllArtist()
        }
    }
}