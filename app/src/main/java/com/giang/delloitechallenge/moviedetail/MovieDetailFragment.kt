package com.giang.delloitechallenge.moviedetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.giang.delloitechallenge.R
import com.giang.delloitechallenge.databinding.FragmentMoviesDetailBinding
import com.giang.delloitechallenge.databinding.FragmentMoviesListBinding
import com.giang.delloitechallenge.movieslist.MoviesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movies_detail) {
  private var _binding: FragmentMoviesDetailBinding? = null
  private val binding get() = _binding!!
  private val viewModel by viewModels<MovieDetailsViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}