package com.dzakyhdr.filmapp.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.data.model.artist.Artist
import com.dzakyhdr.filmapp.databinding.ListPersonItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListPersonItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_person_item,
            parent,
            false
        )

        return ArtistViewHolder((binding))
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val binding: ListPersonItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.txtTitle.text = artist.name
        val posterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imgPerson.context)
            .load(posterUrl)
            .into(binding.imgPerson)
    }
}