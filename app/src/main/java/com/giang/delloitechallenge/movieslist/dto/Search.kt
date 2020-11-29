package com.giang.delloitechallenge.movieslist.dto

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import com.google.gson.annotations.SerializedName

data class Search(
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