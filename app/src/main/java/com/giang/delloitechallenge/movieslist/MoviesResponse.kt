package com.giang.delloitechallenge.movieslist

import com.google.gson.annotations.SerializedName

class MoviesResponse(
  @SerializedName("Search")
  val search: List<Search>,
  val totalResults: String,
  @SerializedName("Response")
  val response: String
)

class Search(
  @SerializedName("Title")
  val title: String,

  @SerializedName("Year")
  val year: String,

  val imdbID: String,

  @SerializedName("Type")
  val type: String,

  @SerializedName("Poster")
  val poster: String
)