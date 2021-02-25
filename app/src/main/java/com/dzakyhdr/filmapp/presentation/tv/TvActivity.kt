package com.dzakyhdr.filmapp.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakyhdr.filmapp.R
import com.dzakyhdr.filmapp.databinding.ActivityTvBinding
import com.dzakyhdr.filmapp.presentation.di.Injector
import javax.inject.Inject

class TvActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TvViewModelFactory
    private lateinit var viewModel: TvViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvTvshow.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.rvTvshow.adapter = adapter
        displayDataTvShow()
    }

    private fun displayDataTvShow() {
        binding.loadingTvshow.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this, tvShowViewModelFactory).get(TvViewModel::class.java)
        viewModel.getTvShow().observe(this,{
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.loadingTvshow.visibility = View.GONE
            } else {
                binding.loadingTvshow.visibility = View.GONE
            }
        })
    }
}