package com.giang.delloitechallenge.movieslist

import com.giang.delloitechallenge.movieslist.dto.MoviesResponse
import javax.inject.Inject

class MoviesRepo @Inject constructor(private val api: MoviesApi) {

  suspend fun getMovies(): MoviesResponse? {
    return try {
      api.getMovies("Marvel", "movie")
    } catch (ex: Exception) {
      null
    }
  }
}
