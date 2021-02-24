package com.dzakyhdr.filmapp.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityTvBinding

class TvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}