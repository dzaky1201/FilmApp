package com.dzakyhdr.filmapp.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.data.model.tvshow.TvShow
import com.dzakyhdr.filmapp.databinding.ListTvshowItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvViewHolder>() {
    private val tvList = ArrayList<TvShow>()

    fun setList(tvShow: List<TvShow>) {
        tvList.clear()
        tvList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListTvshowItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_tvshow_item,
            parent,
            false
        )

        return TvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }
}

class TvViewHolder(private val binding: ListTvshowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        binding.txtTitle.text = tvShow.name
        binding.txtDesription.text = tvShow.overview
        val posterImage = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imgTvshow.context)
            .load(posterImage)
            .into(binding.imgTvshow)
    }
}