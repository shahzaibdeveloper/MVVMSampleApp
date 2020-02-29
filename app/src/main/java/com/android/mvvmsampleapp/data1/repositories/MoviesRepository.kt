package com.android.mvvmsampleapp.data1.repositories

import com.android.mvvmsampleapp.data1.network1.MoviesApi

class MoviesRepository(
    private val api: MoviesApi

) : safeApiRequest() {


    suspend fun getMovies() = apiRequest { api.getMovies() }

}