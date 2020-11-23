package com.giang.delloitechallenge.movieslist.dto

import com.google.gson.annotations.SerializedName

class MoviesResponse(
  @SerializedName("Search")
  val search: List<Search>,
  val totalResults: String,
  @SerializedName("Response")
  val response: String
)

