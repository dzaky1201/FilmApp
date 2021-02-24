package com.dzakyhdr.filmapp.data.repository.artist

import android.util.Log
import com.dzakyhdr.filmapp.data.model.artist.Artist
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.dzakyhdr.filmapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.dzakyhdr.filmapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToDataCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromDataCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToDataCache(artistList)
        }
        return artistList
    }


}