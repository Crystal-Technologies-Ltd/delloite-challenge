package com.giang.delloitechallenge.movieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giang.delloitechallenge.movieslist.dto.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesListViewModel(val movieListRepo: MoviesRepo) : ViewModel() {

  val movieListLiveData: MutableLiveData<MoviesResponse> = MutableLiveData()

  fun getMovieList() {
    viewModelScope.launch(Dispatchers.IO) {
      val result = movieListRepo.getMovies()
    }
  }
}