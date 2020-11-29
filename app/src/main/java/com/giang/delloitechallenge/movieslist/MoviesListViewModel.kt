package com.giang.delloitechallenge.movieslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giang.delloitechallenge.movieslist.dto.MoviesResponseUIState
import com.giang.delloitechallenge.movieslist.dto.Search
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesListViewModel
@ViewModelInject constructor(private val movieListRepo: MoviesRepo) : ViewModel() {

  private var _movieListLD = MutableLiveData<MoviesResponseUIState>()
  val movieListLD: MutableLiveData<MoviesResponseUIState> get() = _movieListLD

  fun getMovieList() {
    viewModelScope.launch(Dispatchers.IO) {
      val result = movieListRepo.getMovies()

      if (result != null) {
        _movieListLD.postValue(
          MoviesResponseUIState(
            movieList = ArrayList<Search>(result.search),
            isSuccess = true
          )
        )
      } else {
        _movieListLD.postValue(
          MoviesResponseUIState(
            movieList = arrayListOf(),
            isSuccess = false
          )
        )
      }
    }
  }
}