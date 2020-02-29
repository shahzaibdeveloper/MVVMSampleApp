package com.android.mvvmsampleapp.data1.network1

import com.android.mvvmsampleapp.data1.model1.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("marvel")

  suspend  fun getMovies():Response<List<Movie>>

    companion object {

        operator fun invoke(): MoviesApi {

           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://simplifiedcoding.net/demos/")
                .build()
                .create(MoviesApi::class.java)

        }
    }

}