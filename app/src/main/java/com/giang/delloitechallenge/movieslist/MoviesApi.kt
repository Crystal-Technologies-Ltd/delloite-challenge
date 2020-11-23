package com.giang.delloitechallenge.movieslist

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("?apikey=b9bd48a6")
    suspend fun getMovies(
        @Query("s") s: String,
        @Query("type") movieType: String
    ): MoviesResponse

}
