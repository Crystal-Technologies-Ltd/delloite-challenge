package com.giang.delloitechallenge.di

import com.giang.delloitechallenge.network.Config
import com.giang.delloitechallenge.network.MoviesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun createInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(Config.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createMovieService(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)

}