package com.giang.delloitechallenge

import com.giang.delloitechallenge.di.RetrofitInstance

class MainActivityRepository {

    val apis = RetrofitInstance.createMovieService(RetrofitInstance.createInstance())

    suspend fun getMovies() {
        apis.getMovies("Marvel", "movie")
    }
}