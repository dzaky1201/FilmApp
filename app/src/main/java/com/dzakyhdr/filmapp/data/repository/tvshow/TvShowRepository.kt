package com.dzakyhdr.filmapp.data.repository.tvshow

import android.util.Log
import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.dzakyhdr.filmapp.domain.repository.TvShowRepository

class TvShowRepository(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        return getMovieFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    private suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getMovieFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}