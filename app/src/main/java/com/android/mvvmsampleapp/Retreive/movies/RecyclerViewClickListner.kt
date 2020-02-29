package com.android.mvvmsampleapp.Retreive.movies

import android.view.View
import com.android.mvvmsampleapp.data1.model1.Movie

interface RecyclerViewClickListner  {



  fun onRecyclerViewItemClick(view: View, movie: Movie)


}