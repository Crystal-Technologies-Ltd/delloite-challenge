package com.giang.delloitechallenge.network

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET("apikey=b9bd48a6&s={s}&type={movieType}")
    suspend fun getMovies(@Path("s") s: String, @Path("movieType") movieType: String): Call

}