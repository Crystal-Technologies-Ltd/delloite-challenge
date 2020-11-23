package com.giang.delloitechallenge.movieslist

import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MoviesRepo {
  val httpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.SECONDS)
    .readTimeout(5, TimeUnit.SECONDS)
    .writeTimeout(5, TimeUnit.SECONDS)
    .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
    .build()

  private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://www.omdbapi.com/")
    .client(httpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  fun createMovieService(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)

  val apis = createMovieService(retrofit)

  suspend fun getMovies(): MoviesResponse {
    return apis.getMovies("Marvel", "movie")
  }
}
