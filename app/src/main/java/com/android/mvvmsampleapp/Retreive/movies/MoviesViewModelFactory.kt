package com.android.mvvmsampleapp.Retreive.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mvvmsampleapp.data1.repositories.MoviesRepository

@Suppress("UCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(
            repository
        ) as T
    }




}