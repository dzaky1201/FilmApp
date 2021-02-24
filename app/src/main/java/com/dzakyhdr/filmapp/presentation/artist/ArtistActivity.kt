package com.dzakyhdr.filmapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}