package com.dzakyhdr.filmapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityMovieBinding
import com.dzakyhdr.filmapp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter

        displayPopularMovie()
    }

    private fun displayPopularMovie() {
        binding.loadingMovie.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
        val responseLiveData = viewModel.getMovies()
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