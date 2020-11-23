package com.giang.delloitechallenge.moviedetail

import com.giang.delloitechallenge.movieslist.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailApi {
    @GET("?apikey=b9bd48a6")
    suspend fun getMovieDetails(@Query("i") movieId: String): MoviesResponse
}