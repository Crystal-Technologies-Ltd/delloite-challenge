package com.giang.delloitechallenge.movieslist.dto

data class MoviesResponseUIState(
  val movieList: List<Search>,
  val isSuccess: Boolean
)