package com.dzakyhdr.filmapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityHomeBinding
import com.dzakyhdr.filmapp.presentation.artist.ArtistActivity
import com.dzakyhdr.filmapp.presentation.movie.MovieActivity
import com.dzakyhdr.filmapp.presentation.tv.TvActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtist.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.btnTvShow.setOnClickListener {
            val intent = Intent(this, TvActivity::class.java)
            startActivity(intent)
        }
    }
}