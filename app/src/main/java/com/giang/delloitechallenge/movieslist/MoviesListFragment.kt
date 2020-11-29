package com.giang.delloitechallenge.movieslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.giang.delloitechallenge.MarginDecorator
import com.giang.delloitechallenge.R
import com.giang.delloitechallenge.dpToPixel
import com.giang.delloitechallenge.movieslist.dto.Search
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies_list.*

@AndroidEntryPoint
class MoviesListFragment : Fragment(R.layout.fragment_movies_list), MoviesAdapter.OnItemClicked {
  private val viewModel by viewModels<MoviesListViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.getMovieList()

    viewModel.movieListLD.observe(viewLifecycleOwner, { res ->
      if (res.isSuccess) {
        (movieList_rcv_movies.adapter as MoviesAdapter)
          .setData((res.movieList as ArrayList<Search>))
        (movieList_rcv_movies.adapter as MoviesAdapter).setOnClickListener(this)
      }
    })
    decorateRecyclerView()
  }

  fun decorateRecyclerView() {
    movieList_rcv_movies.let { rcv ->
      rcv.adapter = MoviesAdapter()
      rcv.addItemDecoration(
        MarginDecorator(
          bottom = requireContext().dpToPixel(15f).toInt(),
        ),
      )
    }
  }

  override fun onItemClicked(imdbId: String) {
    val action = MoviesListFragmentDirections.toFragmentMovieDetails(imdbId)
    findNavController().navigate(action)
  }


}
