package com.dzakyhdr.filmapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityArtistBinding
import com.dzakyhdr.filmapp.presentation.di.Injector
import com.dzakyhdr.filmapp.presentation.movie.MovieAdapter
import com.dzakyhdr.filmapp.presentation.movie.MovieViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ArtistViewModelFactory
    private lateinit var adapter: ArtistAdapter
    private lateinit var viewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvArtist.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.rvArtist.adapter = adapter

        displayPopularArtist()
    }

    private fun displayPopularArtist() {
        binding.loadingMovie.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
        val responseLiveData = viewModel.getArtist()
        responseLiveData.observe(this, {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.loadingMovie.visibility = View.GONE
            } else {
                binding.loadingMovie.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}