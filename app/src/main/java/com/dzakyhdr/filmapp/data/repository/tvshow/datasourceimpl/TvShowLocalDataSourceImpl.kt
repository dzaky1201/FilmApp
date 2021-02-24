package com.dzakyhdr.filmapp.data.repository.tvshow.datasourceimpl

import com.dzakyhdr.filmapp.data.db.TvShowDao
import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val dao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> {
        return dao.getTvShow()
    }

    override suspend fun saveTvShowToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllTvShow()
        }
    }
}