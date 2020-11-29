package com.giang.delloitechallenge.di

import com.giang.delloitechallenge.moviedetail.MovieDetailApi
import com.giang.delloitechallenge.movieslist.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.SECONDS)
    .readTimeout(5, TimeUnit.SECONDS)
    .writeTimeout(5, TimeUnit.SECONDS)
    .protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
    .build()

  @Provides
  @Singleton
  fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .baseUrl("http://www.omdbapi.com")
      .client(client)
      .addConverterFactory(GsonConverterFactory.create())
      .build()


  @Provides
  @Singleton
  fun provideMoviesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)

  @Provides
  @Singleton
  fun providesMovieDetailsApi(retrofit: Retrofit): MovieDetailApi =
    retrofit.create(MovieDetailApi::class.java)

}