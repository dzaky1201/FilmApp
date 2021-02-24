package com.dzakyhdr.filmapp.data.repository.artist.datasourceimpl

import com.dzakyhdr.filmapp.data.model.artist.Artist
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromDataCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToDataCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}