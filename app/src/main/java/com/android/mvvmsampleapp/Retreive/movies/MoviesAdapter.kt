package com.android.mvvmsampleapp.Retreive.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvmsampleapp.R
import com.android.mvvmsampleapp.data1.model1.Movie
import com.android.mvvmsampleapp.databinding.RecyclerMovieBinding


class MoviesAdapter(

    private val movies: List<Movie>, private val listner: RecyclerViewClickListner
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>()
{


    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =MoviesViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_movie,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.reyclerviewMovieBinding.movie = movies[position]

        holder.reyclerviewMovieBinding.t1.setOnClickListener{
            listner.onRecyclerViewItemClick(holder.reyclerviewMovieBinding.t1,movies[position])
        }

        holder.reyclerviewMovieBinding.t2.setOnClickListener{
            listner.onRecyclerViewItemClick(holder.reyclerviewMovieBinding.t2,movies[position])
        }

    }

    inner class MoviesViewHolder(

        val reyclerviewMovieBinding: RecyclerMovieBinding
    ) : RecyclerView.ViewHolder(reyclerviewMovieBinding.root)
}