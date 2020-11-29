package com.giang.delloitechallenge.movieslist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.giang.delloitechallenge.R
import com.giang.delloitechallenge.databinding.FragmentMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {
  private var _binding: FragmentMoviesListBinding? = null
  private val binding get() = _binding!!
  private val viewModel by viewModels<MoviesListViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.getMovieList()

    viewModel.movieListLD.observe(viewLifecycleOwner, { res ->
      if (res.isSuccess) {
        Toast.makeText(requireContext(), "Success! + ${res.movieList.size}", Toast.LENGTH_SHORT).show()
      }
    })
  }
}
