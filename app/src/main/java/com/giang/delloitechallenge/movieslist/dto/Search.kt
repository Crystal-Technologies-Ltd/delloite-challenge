package com.giang.delloitechallenge.movieslist.dto

import com.google.gson.annotations.SerializedName

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